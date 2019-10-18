package com.restaurant.client.feign.endpoint;


import api.dto.MealDTO;
import com.restaurant.client.feign.provider.RestaurantProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/meal")
public class FeignController {

    @Autowired
    RestaurantProvider restaurantProvider;

    @PostMapping("/save")
    public MealDTO save(@RequestBody MealDTO mealDTO) {
        return restaurantProvider.save(mealDTO);
    }

    @PutMapping("/update")
    public MealDTO update(@RequestBody MealDTO mealDTO) {
        return restaurantProvider.update(mealDTO);
    }

    @GetMapping("/get")
    public MealDTO get(@RequestParam String uuid) {
        return restaurantProvider.get(uuid);
    }

    @DeleteMapping("/delete/{uuid}")
    public boolean delete(@PathVariable(name = "uuid") String uuid) {
        return restaurantProvider.delete(uuid);
    }
}
