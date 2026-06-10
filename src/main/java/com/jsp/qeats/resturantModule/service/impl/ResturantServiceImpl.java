package com.jsp.qeats.resturantModule.service.impl;

import com.jsp.qeats.commonModule.exception.UserException;
import com.jsp.qeats.resturantModule.dto.FoodItemRequest;
import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.dto.ResturantRequest;
import com.jsp.qeats.resturantModule.dto.ResturantResponse;
import com.jsp.qeats.resturantModule.model.FoodItem;
import com.jsp.qeats.resturantModule.model.Resturant;
import com.jsp.qeats.resturantModule.repository.FoodItemRepository;
import com.jsp.qeats.resturantModule.repository.ResturantRepository;
import com.jsp.qeats.resturantModule.service.ResturantService;
import com.jsp.qeats.userModule.model.Role;
import com.jsp.qeats.userModule.model.User;
import com.jsp.qeats.userModule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResturantServiceImpl  implements ResturantService {

    private final UserRepository userRepository;
    private final ResturantRepository resturantRepository;


    @Override
    public ResturantResponse createResturant(ResturantRequest resturantRequest) {

        Integer managerId = resturantRequest.getUser_Id();

        User user = userRepository.findById(managerId).orElseThrow(() -> new UserException("invalid user id"));

        Resturant resturant = new Resturant(resturantRequest);
        resturant.setManager(user);

        user.setResturant(resturant);
        resturantRepository.save(resturant);
        userRepository.save(user);

        return new ResturantResponse(resturant);
}

    public ResturantResponse findById(Long resturantId) {
        Resturant resturant=resturantRepository.findById(resturantId).orElseThrow(()->new UserException("invalid resturant id"));
        return new ResturantResponse(resturant);
    }


    public ResturantResponse findByName(String resturantName){
        Resturant resturant=resturantRepository.findByresturantName(resturantName).orElseThrow(()-> new RuntimeException ("Error"));
        return new ResturantResponse(resturant);

    }

    public List<ResturantResponse> findAll(){
        List<Resturant> rs=resturantRepository.findAll();
        List<ResturantResponse> list =new ArrayList();
        for(Resturant r:rs){
            ResturantResponse rr=new ResturantResponse(r);
            list.add(rr);
        }
        return list;
    }

    public List<ResturantResponse> findByCity(String city){
        List<Resturant> rs=resturantRepository.findAllByCity(city);
        List<ResturantResponse> list=new ArrayList<>();

        for(Resturant r:rs){
            if(r.getCity().equals(city)){
                ResturantResponse rr=new ResturantResponse(r);
                list.add(rr);
            }
        }return list;
    }

    @Override
    public ResturantResponse updateResturant(Long resturantId,Integer manager_id) {
      Resturant resturant=resturantRepository.findById(resturantId).orElseThrow(()-> new UserException("Not found"));
      User user=userRepository.findById(manager_id).orElseThrow(()-> new UserException("Not found"));
       resturant.setManager(user);
       user.setResturant(resturant);
       user.setRole(Role.HOTEL_OWNER);
        resturantRepository.save(resturant);
       userRepository.save(user);


       return new ResturantResponse(resturant);
    }





}
