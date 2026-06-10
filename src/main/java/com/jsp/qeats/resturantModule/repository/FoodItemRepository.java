package com.jsp.qeats.resturantModule.repository;

import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {

    Optional<FoodItem> findByFoodName(String foodName);
     Optional<FoodItem> findById(Integer foodId);


//    FoodItemResponse createFoodItem(FoodItemRequest foodItemRequest);
//    FoodItemResponse updateFoodItem(Integer foodId,Double price);
}
