package com.example.hotel.demo.Service;

import com.example.hotel.demo.Entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(int hotelId);
}
