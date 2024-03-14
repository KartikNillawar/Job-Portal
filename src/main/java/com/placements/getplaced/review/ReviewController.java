package com.placements.getplaced.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable Long companyId,@RequestBody Review review)
    {
        boolean isReviewAdded = reviewService.addReview(companyId,review);
        if(isReviewAdded)
            return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Added, Company not found",HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        Review review = reviewService.getReviewById(companyId,reviewId);
        if(review!=null)
            return new ResponseEntity<>(review,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,@PathVariable Long reviewId, @RequestBody Review review)
    {
        boolean isUpdated = reviewService.updateReviewById(companyId,reviewId, review);
        if(isUpdated)
            return new ResponseEntity<>("The review is updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("The review is not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        boolean isdeleted = reviewService.deleteReviewById(companyId,reviewId);
        if(isdeleted)
            return new ResponseEntity<>("The review is deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("The review is not deleted", HttpStatus.NOT_FOUND);
    }


}
