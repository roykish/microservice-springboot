package com.example.UserServiceApplication.service.Implementation;

import com.example.UserServiceApplication.Entity.Hotel;
import com.example.UserServiceApplication.Entity.Rating;
import com.example.UserServiceApplication.Entity.User;
import com.example.UserServiceApplication.exception.ResourceNotFoundException;
import com.example.UserServiceApplication.external.HotelService;
import com.example.UserServiceApplication.repository.UserRepository;
import com.example.UserServiceApplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

    @Override
    public User saveUser(User user) {
        String randomUserId  = String.valueOf(UUID.randomUUID());
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= userRepository.findAll();
        if(users.isEmpty()){
            throw new ResourceNotFoundException("No user has been found");
        }else{
            for(User user : users){
                user.setRatings(findAllRatingsOfUser(user.getUserId()));
            }
            return users;
        }
    }

    @Override
    public User getSingleUser(String userId) {
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new ResourceNotFoundException("User has not found with the provided ID");
            } else {
                user.setRatings(findAllRatingsOfUser(user.getUserId()));
                return user;
            }
        } catch (ResourceNotFoundException exception) {
            System.err.println(exception.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public User removeUser(long UserId) {
        return null;
    }

    @Override
    public List<Rating> findAllRatingsOfUser(String userId) {
        /*
        On the URL, we used the service name instead of local host and port number. this is called load balancer
        we have used an annotation in the config class where we've created rest template bean.
         */

        Rating[] fetchAllRatingOfUser = restTemplate.getForObject("http://rating-service/rating/user/" + userId, Rating[].class);
        List<Rating> ratings = Arrays.stream(fetchAllRatingOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            /*
            Calling other microservice by restTemplate
            */
           // ResponseEntity<Hotel> fetchedRatedHotels = restTemplate.getForEntity("http://hotel-service/hotel/findHotel/" + rating.getHotelId(), Hotel.class);
           // rating.setHotel(fetchedRatedHotels.getBody());
            /*
            calling other microservice using feignClient
             */
            rating.setHotel(hotelService.getHotel(rating.getHotelId()));

            return rating;
        }).collect(Collectors.toList());
        return ratingList;
    }
}
