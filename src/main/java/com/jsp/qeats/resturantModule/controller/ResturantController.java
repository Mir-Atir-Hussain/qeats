package com.jsp.qeats.resturantModule.controller;

import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.dto.ResturantRequest;
import com.jsp.qeats.resturantModule.dto.ResturantResponse;
import com.jsp.qeats.resturantModule.model.Resturant;
import com.jsp.qeats.resturantModule.service.ResturantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResturantController {

    private final ResturantService resturantService;

    @PostMapping("/api/createResturant")
    public ResponseEntity<ResturantResponse> createResturant(@RequestBody ResturantRequest resturantRequest) {
        return ResponseEntity.status(201).body(resturantService.createResturant(resturantRequest));
    }

    @GetMapping("/api/findbyId")
    public ResponseEntity<ResturantResponse> findById(@RequestParam Long resturantId) {
        return ResponseEntity.status(201).body(resturantService.findById(resturantId));
    }

    @GetMapping("/api/findAll")
    public ResponseEntity<List<ResturantResponse>> findAll() {
        return ResponseEntity.status(201).body(resturantService.findAll());
    }

    @GetMapping("/api/findByCity")
    public ResponseEntity<List<ResturantResponse>> findByCity(@RequestParam String city) {
        return ResponseEntity.status(201).body(resturantService.findByCity(city));
    }

    @PatchMapping("/api/updateManager")
    public ResponseEntity<ResturantResponse> update(@RequestParam Long resturantId,@RequestParam Integer id) {
        return ResponseEntity.status(201).body(resturantService.updateResturant(resturantId,id));
    }


}
