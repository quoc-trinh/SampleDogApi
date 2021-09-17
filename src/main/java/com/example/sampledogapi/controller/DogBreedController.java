package com.example.sampledogapi.controller;

import com.example.sampledogapi.dto.DogBreedResponse;
import com.example.sampledogapi.service.DogBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dog/breeds")
public class DogBreedController {

    @Autowired
    private DogBreedService service;

    @RequestMapping("list/all")
    public ResponseEntity<DogBreedResponse> getAll(){
        Map<String, List<String>> dogBreedData = service.getDogBreedData();
        if (dogBreedData != null){
            return new ResponseEntity<>(new DogBreedResponse(dogBreedData, "success"), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
