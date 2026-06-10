package com.jsp.qeats.resturantModule.dto;

import com.jsp.qeats.resturantModule.model.Resturant;
import lombok.Data;

import java.time.LocalTime;
@Data
public class ResturantResponse {



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


    public ResturantResponse(Resturant resturant){
        this.resturantName = resturant.getResturantName();
        this.phone = resturant.getPhone();
        this.Address = resturant.getAddress();
        this.city = resturant.getCity();
        this.state = resturant.getState();
        this.Country = resturant.getCountry();
        this.image = resturant.getImage();
        this.openingTime = resturant.getOpeningTime();
        this.closingTime = resturant.getClosingTime();
//        this.isActive = resturant.getIsActive();
    }
}
