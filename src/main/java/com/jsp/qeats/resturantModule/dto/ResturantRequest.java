package com.jsp.qeats.resturantModule.dto;

import lombok.Data;

import java.time.LocalTime;
@Data
public class ResturantRequest {
    private String resturantName;
    private Long phone;
    private String Address;
    private String city;
    private String state;
    private String Country;
    private String image;
    private LocalTime openingTime;
    private LocalTime closingTime;
//    private Boolean isActive;
    private Integer user_Id;
}
