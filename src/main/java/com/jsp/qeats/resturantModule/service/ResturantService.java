package com.jsp.qeats.resturantModule.service;

import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.dto.ResturantRequest;
import com.jsp.qeats.resturantModule.dto.ResturantResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResturantService {
    ResturantResponse createResturant(ResturantRequest resturantRequest);
    ResturantResponse findById(Long resturantId);
    ResturantResponse findByName(String resturantName);
    List<ResturantResponse> findAll();
    List<ResturantResponse> findByCity(String city);
   ResturantResponse updateResturant(Long resturantId,Integer manager_id);
//    ResturantResponse deleteResturant(Integer resturantId);


}
