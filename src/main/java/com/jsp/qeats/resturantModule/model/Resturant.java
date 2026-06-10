package com.jsp.qeats.resturantModule.model;

import com.jsp.qeats.resturantModule.dto.FoodItemResponse;
import com.jsp.qeats.resturantModule.dto.ResturantRequest;
import com.jsp.qeats.userModule.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Resturant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resturantId;
    private String resturantName;
    private Long phone;
    private String Address;
    private String city;
    private String state;
    private String Country;
    private String image;
    private LocalTime openingTime;
    private LocalTime closingTime;

//    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="manager_id")
    private User manager;

    @OneToMany(mappedBy = "resturant",cascade = CascadeType.ALL)
    private List<FoodItem> foodItems;

    public Resturant(ResturantRequest resturantRequest) {
        this.resturantName=resturantRequest.getResturantName();
        this.phone=resturantRequest.getPhone();
        this.Address=resturantRequest.getAddress();
        this.city=resturantRequest.getCity();
        this.Country=resturantRequest.getCountry();
        this.state=resturantRequest.getState();
//        this.image=resturantRequest.getImage();
        this.openingTime=resturantRequest.getOpeningTime();
        this.closingTime=resturantRequest.getClosingTime();
    }

}
