package com.example.UserServiceApplication.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String remark;

    private Hotel hotel;
}
