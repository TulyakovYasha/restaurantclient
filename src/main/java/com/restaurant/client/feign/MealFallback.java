package com.restaurant.client.feign;


import api.dto.MealDTO;
import com.restaurant.client.feign.client.RestaurantFeignClient;
import org.springframework.stereotype.Component;

@Component
public class MealFallback implements RestaurantFeignClient {
    @Override
    public MealDTO save(MealDTO mealDTO) {
        return new MealDTO();
    }

    @Override
    public MealDTO update(MealDTO mealDTO) {
        return new MealDTO();
    }

    @Override
    public MealDTO get(String uuid) {
        return new MealDTO();
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }
}
