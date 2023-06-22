package com.example.Hotel.service;

import com.example.Hotel.entity.MyHotels;

import java.util.List;

public interface MyHotelsService {
    void addHotels(MyHotels myHotels);

    List<MyHotels> getAllHotels();

    MyHotels getById(Long id);

    void updateHotels(Long id, MyHotels myHotels);

    List<MyHotels> getByName(String name);
}
