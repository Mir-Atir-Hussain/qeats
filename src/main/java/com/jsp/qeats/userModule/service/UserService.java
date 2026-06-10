package com.jsp.qeats.userModule.service;

import com.jsp.qeats.userModule.dto.LoginRequest;
import com.jsp.qeats.userModule.dto.UserRequest;
import com.jsp.qeats.userModule.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse register(UserRequest user);
    UserResponse login(LoginRequest login);
    UserResponse profile(Integer id);
}
