package com.example.Hotel.controller;

import com.example.Hotel.entity.MyHotels;
import com.example.Hotel.service.MyHotelsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class MyHotelsController {
    @Autowired
    private MyHotelsService myHotelsService;

    @PostMapping
    public String addHotels(@RequestBody MyHotels myHotels) {
        myHotelsService.addHotels(myHotels);
        return "Added Successfully";
    }

    @GetMapping
    public List<MyHotels> getAllHotels(){
        return myHotelsService.getAllHotels();
    }
    @GetMapping("/name/{name}")
    public List<MyHotels> getByName(@PathVariable String name)
    {
        return myHotelsService.getByName(name);
    }

    @GetMapping("/get")
    public MyHotels getById(@RequestParam Long id)
    {
        return myHotelsService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateHotels(@PathVariable Long id, @RequestBody MyHotels myHotels)
    {
        myHotelsService.updateHotels(id, myHotels);
        return ResponseEntity.noContent().build();
    }


}
