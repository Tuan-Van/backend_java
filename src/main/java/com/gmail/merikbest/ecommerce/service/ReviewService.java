package com.gmail.merikbest.ecommerce.service;

import com.gmail.merikbest.ecommerce.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByPerfumeId(Long perfumeId);

    Review addReviewToPerfume(Review review, Long perfumeId);
}
