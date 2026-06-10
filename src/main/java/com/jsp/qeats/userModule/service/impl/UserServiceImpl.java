package com.jsp.qeats.userModule.service.impl;//package com.jsp.qeats.userModule.service.impl;

import com.jsp.qeats.commonModule.exception.UserException;
import com.jsp.qeats.userModule.dto.LoginRequest;
import com.jsp.qeats.userModule.dto.UserRequest;
import com.jsp.qeats.userModule.dto.UserResponse;
import com.jsp.qeats.userModule.model.Role;
import com.jsp.qeats.userModule.model.User;
import com.jsp.qeats.userModule.repository.UserRepository;
import com.jsp.qeats.userModule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor()
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserResponse register(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new UserException("email id alreay exist");
        }
        User user=new User(userRequest);
        user.setRole(Role.CUSTOMER);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setActive(true);
        User saveUser=userRepository.save(user);

        return new UserResponse(saveUser);
    }

    @Override
    public UserResponse login(LoginRequest login) {
        User user=userRepository.findByEmail(login.getEmail()).orElseThrow(()->new UserException("invalid email id"));
        if(user.getActive()) {
            if (!user.getPassword().equals(login.getPassword())) {
                throw new UserException("invalid password");
            }
            return new UserResponse(user);
        }else{
            throw new UserException("user is not active");
        }
    }

    @Override
    public UserResponse profile(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->new UserException("invalid user id"));
        if(user.getActive()){
            return new UserResponse(user);
        }else{
            throw new UserException("user is not active");
        }

    }

    public UserResponse delete(Integer id){
        User user=userRepository.findById(id).orElseThrow(()-> new UserException("invalid user id "));
        if(user.getActive()){
            userRepository.delete(user);
            return new UserResponse(user);
        }else{
            throw new UserException("user is not active");
        }

    }

    public UserResponse update(String email, String oldPassword,String newPassword){
        User user=userRepository.findByEmail(email).orElseThrow(()->new UserException("invalid user id "));
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            userRepository.save(user);
        }

        return new UserResponse(user);


    }
}
