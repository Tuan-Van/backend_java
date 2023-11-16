package com.gmail.merikbest.ecommerce.repository;

import com.gmail.merikbest.ecommerce.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderByIdAsc();

    Page<Order> findAllByOrderIdAsc(Pageable pageable);

    List<Order> findOrderByEmail(String email);

    Page<Order> findOrderByEmail(String email, Pageable pageable);

    Page<Order> findAllByOrderByIdAsc(Pageable pageable);
}
