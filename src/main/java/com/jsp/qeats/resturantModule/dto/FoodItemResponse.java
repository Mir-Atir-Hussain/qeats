package com.jsp.qeats.resturantModule.dto;

import com.jsp.qeats.resturantModule.model.FoodItem;
import lombok.Data;

@Data
public class FoodItemResponse {

//    private Integer foodId;
    private String foodName;
    private Double price;
    private String discription;
    private String category;
    private String imageUrl;
    private Boolean isAvailable;
    private String stock;
    private String resturantName;

    public FoodItemResponse(FoodItem foodItem){
        this.foodName=foodItem.getFoodName();
        this.price=foodItem.getPrice();
        this.discription=foodItem.getDiscription();
        this.category=foodItem.getCategory();
        this.imageUrl=foodItem.getImageUrl();
        this.isAvailable=foodItem.getIsAvailable();
        this.stock=foodItem.getStock();
        this.resturantName=foodItem.getResturant().getResturantName();
    }
}
