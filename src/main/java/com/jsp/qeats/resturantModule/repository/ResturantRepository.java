package com.jsp.qeats.resturantModule.repository;

import com.jsp.qeats.resturantModule.dto.ResturantResponse;
import com.jsp.qeats.resturantModule.model.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResturantRepository extends JpaRepository<Resturant,Long> {

    Optional<Resturant> findByresturantName(String resturantName);
     List<Resturant> findAllByCity(String city);
}
