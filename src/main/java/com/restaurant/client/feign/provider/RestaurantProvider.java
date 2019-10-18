package com.restaurant.client.feign.provider;

import api.dto.MealDTO;
import com.restaurant.client.feign.client.RestaurantFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantProvider {

    @Autowired
    RestaurantFeignClient restaurantFeignClient;

    public MealDTO save(MealDTO mealDTO) {
        return restaurantFeignClient.save(mealDTO);
    }

    public MealDTO update(MealDTO meal) {
        return restaurantFeignClient.update(meal);
    }

    public MealDTO get(String uuid) {
        return restaurantFeignClient.get(uuid);
    }

    public boolean delete(String uuid) {
        return restaurantFeignClient.delete(uuid);
    }
}
