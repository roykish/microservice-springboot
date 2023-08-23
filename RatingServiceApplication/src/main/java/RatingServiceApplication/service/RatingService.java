package RatingServiceApplication.service;

import RatingServiceApplication.Entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);
}
