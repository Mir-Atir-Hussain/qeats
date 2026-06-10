package com.jsp.qeats.resturantModule.service.impl;

import com.jsp.qeats.commonModule.exception.UserException;
import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.model.FoodItem;
import com.jsp.qeats.resturantModule.model.Resturant;
import com.jsp.qeats.resturantModule.repository.FoodItemRepository;
import com.jsp.qeats.resturantModule.repository.ResturantRepository;
import com.jsp.qeats.resturantModule.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final ResturantRepository resturantRepository;

    public FoodItemResponse createFoodItem(FoodItemRequest foodItemRequest){
    Resturant resturant=resturantRepository.findById(foodItemRequest.getResturantId()).orElseThrow(()-> new UserException("Not found"));

       FoodItem foodItem=new FoodItem(foodItemRequest);
       foodItem.setIsAvailable(true);
       foodItem.setResturant(resturant);
        foodItemRepository.save(foodItem);

        return new FoodItemResponse(foodItem);

    }


    public FoodItemResponse findById(Integer foodId){
        FoodItem foodItem=foodItemRepository.findById(foodId).orElseThrow(()-> new UserException("Resturant Not found"));
        return new FoodItemResponse(foodItem);
    }

    public FoodItemResponse updateFoodItem(Integer foodId,Double price){
        FoodItem foodItem=foodItemRepository.findById(foodId).orElseThrow(()-> new UserException("Resturant Not found"));

        foodItem.setPrice(price);
        foodItemRepository.save(foodItem);
        return new FoodItemResponse(foodItem);
    }
}
