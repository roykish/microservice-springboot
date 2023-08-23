package com.example.UserServiceApplication.external;

import com.example.UserServiceApplication.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service")
public interface HotelService {

    @GetMapping("/hotel/findHotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
