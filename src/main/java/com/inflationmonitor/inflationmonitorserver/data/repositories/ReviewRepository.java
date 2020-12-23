package com.inflationmonitor.inflationmonitorserver.data.repositories;

import com.inflationmonitor.inflationmonitorserver.data.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Override
    List<Review> findAll();
}
