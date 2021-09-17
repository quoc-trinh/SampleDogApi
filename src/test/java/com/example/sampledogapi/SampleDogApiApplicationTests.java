package com.example.sampledogapi;

import com.example.sampledogapi.controller.DogBreedController;
import com.example.sampledogapi.dto.DogBreedResponse;
import com.example.sampledogapi.service.DogBreedService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleDogApiApplicationTests {

    @LocalServerPort
    private String port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private DogBreedController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(testRestTemplate).isNotNull();
        assertThat(port).isNotNull();
    }

    @Test
    public void testGetAllData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        DogBreedResponse expectedResponse = objectMapper.readValue(DogBreedDataTest.DOG_BREED, DogBreedResponse.class);

        ResponseEntity<DogBreedResponse> result = testRestTemplate.getForEntity("http://localhost:" + port + "/api/dog/breeds/list/all", DogBreedResponse.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(expectedResponse);
    }
}
