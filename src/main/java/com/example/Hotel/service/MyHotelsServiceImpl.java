package com.example.Hotel.service;

import com.example.Hotel.entity.MyHotels;
import com.example.Hotel.repository.MyHotelRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class MyHotelsServiceImpl implements MyHotelsService{
    @Autowired
    private MyHotelRepo myHotelRepo;

    @Override
    public void addHotels(MyHotels myHotels) {
        myHotelRepo.save(myHotels);
    }

    @Override
    public List<MyHotels> getAllHotels() {
        return myHotelRepo.findAll() ;
    }

    @Override
    public MyHotels getById(Long id) {
        return myHotelRepo.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Hotel id"+ id));
    }

    @Override
    public void updateHotels(Long id, MyHotels myHotels) {
        myHotelRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Hotel id"+id));
        myHotels.setId(id);
        myHotelRepo.save(myHotels);
    }

    @Override
    public List<MyHotels> getByName(String name) {
        return myHotelRepo.findByName(name);
    }
}
