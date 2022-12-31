package com.audiosharing.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.Review;
import com.audiosharing.demo.models.values.ReviewValue;
import com.audiosharing.demo.repositories.ReviewRepository;

@Service
public class ReviewSerivce {
	private final ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewSerivce(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Transactional
	public Review save(ReviewValue value) {
		Review review = Review.builder()
				.reviewPurpose(value.getReviewPurpose())
				.reviewSound(value.getReviewSound())
				.reviewFit(value.getReviewFit())
				.reviewDesign(value.getReviewDesign())
				.reviewDetail(value.getReviewDetail())
				.build();
		
		return reviewRepository.save(review);
	}
}
