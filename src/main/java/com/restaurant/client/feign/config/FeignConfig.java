package com.restaurant.client.feign.config;


import com.restaurant.client.feign.provider.RestaurantProvider;
import feign.Logger;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = {
        RestaurantProvider.class
})
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
