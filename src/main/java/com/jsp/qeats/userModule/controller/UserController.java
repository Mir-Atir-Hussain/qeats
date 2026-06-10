package com.jsp.qeats.userModule.controller;

import com.jsp.qeats.userModule.dto.LoginRequest;
import com.jsp.qeats.userModule.dto.UserRequest;
import com.jsp.qeats.userModule.dto.UserResponse;
import com.jsp.qeats.userModule.model.User;
import com.jsp.qeats.userModule.service.UserService;
import com.jsp.qeats.userModule.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

  private final  UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.register(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.login(loginRequest));
    }
    @GetMapping("/find")
    public ResponseEntity<UserResponse> findUserById(@RequestParam Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.profile(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Integer id){
        userServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestParam String email,@RequestParam String oldPassword,@RequestParam String newPassword){
        userServiceImpl.update(email,oldPassword,newPassword);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
    }

}
