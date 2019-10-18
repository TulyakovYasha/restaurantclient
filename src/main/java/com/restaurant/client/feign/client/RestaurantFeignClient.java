package com.restaurant.client.feign.client;


import api.dto.MealDTO;
import com.restaurant.client.feign.MealFallback;
import com.restaurant.client.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "restauran", url = "localhost:8080/meal", configuration = FeignConfig.class, fallback = MealFallback.class)
public interface RestaurantFeignClient {

    @RequestMapping(method = RequestMethod.POST, path = "/save",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MealDTO save(@RequestBody MealDTO mealDTO);

    @RequestMapping(method = RequestMethod.PUT, path = "/update",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MealDTO update(@RequestBody MealDTO mealDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/get",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MealDTO get(@RequestParam String uuid);

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{uuid}")
    boolean delete(@PathVariable(name = "uuid") String uuid);

}
