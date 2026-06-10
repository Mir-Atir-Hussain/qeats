package com.jsp.qeats.resturantModule.dto;

import lombok.Data;

@Data
public class FoodItemRequest {

    private Integer foodId;
    private String foodName;
    private Double price;
    private String discription;
    private String category;
    private String imageUrl;
    private Boolean isAvailable;
    private String stock;


    private Long resturantId;
}
