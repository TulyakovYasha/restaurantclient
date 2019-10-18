package com.restaurant.client;

import api.dto.MealDTO;
import com.restaurant.client.rest.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestTemplate {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplate.class);

    public static void main(String[] args) {
        RestTemplateService restTemplateService = new RestTemplateService();

        restTemplateService.save(new MealDTO("testMealName", 12, 13, 12));

        restTemplateService.get(restTemplateService.savedMealUuid);

        restTemplateService.update(new MealDTO(restTemplateService.savedMealUuid, "updatedTestMealName", 21, 23, 123));

        restTemplateService.delete(restTemplateService.savedMealUuid);
    }
}
