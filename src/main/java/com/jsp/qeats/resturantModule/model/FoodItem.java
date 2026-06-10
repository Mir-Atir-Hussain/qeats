package com.jsp.qeats.resturantModule.model;

import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;
    private String foodName;
    private Double price;
    private String discription;
    private String category;
    private String imageUrl;
    private Boolean isAvailable;
    private String stock;


    @ManyToOne
    private Resturant resturant;

     public FoodItem(FoodItemRequest foodItemRequest) {
        this.foodName = foodItemRequest.getFoodName();
        this.price = foodItemRequest.getPrice();
        this.discription = foodItemRequest.getDiscription();
        this.category = foodItemRequest.getCategory();
        this.imageUrl = foodItemRequest.getImageUrl();
        this.stock=foodItemRequest.getStock();

    }


}
