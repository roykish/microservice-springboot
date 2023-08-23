package com.example.hotel.demo.Service.Implementation;

import com.example.hotel.demo.Entity.Hotel;
import com.example.hotel.demo.Service.HotelService;
import com.example.hotel.demo.exception.ResourceNotFoundException;
import com.example.hotel.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with id " + hotelId + " has not found on server."));
    }
}
