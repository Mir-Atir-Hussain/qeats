package com.jsp.qeats.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedV
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;
}
