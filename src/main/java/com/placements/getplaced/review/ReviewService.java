package com.placements.getplaced.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReviewById(Long companyId,Long reviewId);

    boolean updateReviewById(Long companyId, Long ReviewId, Review review);

    boolean deleteReviewById(Long companyId, Long ReviewId);

}
