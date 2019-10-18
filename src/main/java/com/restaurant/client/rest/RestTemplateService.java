package com.restaurant.client.rest;

import api.dto.MealDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class RestTemplateService {

    public String savedMealUuid;

    private String url = getUrl();

    private String getUrl() {
        try {
            FileInputStream fis = new FileInputStream("config/application.properties");
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty("feign.url");
        } catch (IOException e) {
            return "Not found conf file";
        }
    }

    public MealDTO save(MealDTO mealDTO) {
        RestTemplate restTemplate = new RestTemplate();
        MealDTO dto = restTemplate.postForObject(url + "/save", mealDTO, MealDTO.class);
        if (dto.isExist()) {
            savedMealUuid = dto.getUuid();
        }
        return dto;
    }

    public MealDTO update(MealDTO mealDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url + "/update", mealDTO, MealDTO.class);
        return get(mealDTO.getUuid());
    }

    public MealDTO get(String uuid) {
        Map<String, String> params = new HashMap<>();
        params.put("uuid", uuid);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url + "/get?uuid=" + uuid, MealDTO.class);
    }

    public void delete(String uuid) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url + "/delete/" + uuid);
    }

}
