package com.jsp.qeats.resturantModule.service;

import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import org.springframework.stereotype.Service;

@Service
public interface FoodItemService {

    FoodItemResponse createFoodItem(FoodItemRequest foodItemRequest);
    FoodItemResponse findById(Integer foodId);

    FoodItemResponse updateFoodItem(Integer foodId, Double price);



//     FoodItemResponse updateFoodItem(Long resturantId,Long foodItemId,FoodItemResponse foodItemResponse);
//     String deleteFoodItem(Long resturantId,Long foodItemId);
//      List<FoodItemResponse> findAllFoodItems(Long resturantId);
//       FoodItemResponse findByFoodItemId(Long resturantId,Integer foodItemId);
//
}

