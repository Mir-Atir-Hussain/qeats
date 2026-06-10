package com.jsp.qeats.userModule.dto;

import com.jsp.qeats.userModule.model.User;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private Long phone;
    private String password;

}

