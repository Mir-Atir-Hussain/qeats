package com.jsp.qeats.resturantModule.controller;

import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.repository.FoodItemRepository;
import com.jsp.qeats.resturantModule.service.ResturantService;
import com.jsp.qeats.resturantModule.service.impl.FoodItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemServiceImpl foodItemService;

    @PostMapping("/api/addFood")
    public ResponseEntity<FoodItemResponse> createFoodItem(@RequestBody FoodItemRequest foodItemRequest) {
        return ResponseEntity.status(201).body(foodItemService.createFoodItem(foodItemRequest));
    }

    @GetMapping("/api/findFoodById")
    public ResponseEntity<FoodItemResponse> findById(@RequestParam Integer foodId) {
        return ResponseEntity.status(201).body(foodItemService.findById(foodId));
    }

    @PutMapping("/api/updatePrice")
    public ResponseEntity<FoodItemResponse> updateFoodItem(@RequestParam Integer foodId,@RequestParam Double price) {
        return ResponseEntity.status(201).body(foodItemService.updateFoodItem(foodId,price));
    }
}
