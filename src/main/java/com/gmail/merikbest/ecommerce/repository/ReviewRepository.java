package com.gmail.merikbest.ecommerce.repository;

import com.gmail.merikbest.ecommerce.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
