package com.audiosharing.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiosharing.demo.models.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	Optional<Review> findByReviewNoPk(Long reviewNoPk);
	List<Review> findAll();
}
