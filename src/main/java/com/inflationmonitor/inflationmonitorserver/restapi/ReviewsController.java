package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.data.entities.Review;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping(path = "/all")
    private List<Review> readAllReviews() {
        return reviewRepository.findAll();
    }

    @PostMapping(path = "save")
    private void saveReview(@RequestBody Review requestBody) {
        reviewRepository.saveAndFlush(requestBody);
    }
}
