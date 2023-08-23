package com.example.hotel.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelStaffController {
    @GetMapping("/staff")
    public ResponseEntity<List<String>> getStaffs(){
         List<String> list = Arrays.asList("Kishor","Akash");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
