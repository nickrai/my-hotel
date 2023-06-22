package com.example.Hotel.repository;

import com.example.Hotel.entity.MyHotels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyHotelRepo extends JpaRepository<MyHotels,Long> {
    List<MyHotels> findByName(String name);
    List<MyHotels> findByAddress(String address);

}
