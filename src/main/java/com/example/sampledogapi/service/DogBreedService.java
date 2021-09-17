package com.example.sampledogapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class DogBreedService {
    public Map<String, List<String>> getDogBreedData(){
        InputStream inputJsonDataStream = TypeReference.class.getResourceAsStream("/json/apidata.json");
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        try {
            return jsonObjectMapper.readValue(inputJsonDataStream, Map.class);
        } catch (IOException e) {
            System.out.println("Cannot read the json from the data" + e.getMessage());
        }
        return null;
    }
}
