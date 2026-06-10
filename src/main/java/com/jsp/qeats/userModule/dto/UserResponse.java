package com.jsp.qeats.userModule.dto;

import com.jsp.qeats.userModule.model.User;
import lombok.Data;

@Data
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private Long phone;

    public UserResponse(User user){
       this.id=user.getId();
       this.name=user.getName();
       this.email=user.getEmail();
       this.phone=user.getPhone();
    }
}
