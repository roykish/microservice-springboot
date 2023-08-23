package com.example.hotel.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "hotel_location")
    private String hotelLocation;
    @Column(name = "hotel_about")
    private String hotelAbout;

}
