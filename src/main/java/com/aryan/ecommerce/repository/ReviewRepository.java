package com.aryan.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.ecommerce.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
