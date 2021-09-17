package com.example.sampledogapi;

import com.example.sampledogapi.controller.DogBreedController;
import com.example.sampledogapi.service.DogBreedService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogBreedController.class)
public class DogBreedControllerUTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private DogBreedService service;

    @Test
    public void testGetAllData() throws Exception {
        mockMvc.perform(get("/api/dog/breeds/list/all"))
                .andExpect(status().isOk())
                .andExpect(content().string(DogBreedDataTest.DOG_BREED));
    }
}
