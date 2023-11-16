package com.gmail.merikbest.ecommerce.service;

import com.gmail.merikbest.ecommerce.domain.Order;
import com.gmail.merikbest.ecommerce.domain.OrderItem;
import graphql.schema.DataFetcher;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Order getOrderById(Long orderId);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);

    Page<Order> getAllOrders(Pageable pageable);

    Page<Order> getUserOrders(String email, Pageable pageable);

    Order postOrder(Order validOrder, Map<Long, Long> perfumesId) throws MessagingException;

    String deleteOrder(Long orderId);

    DataFetcher<List<Order>> getAllOrderByQuery();

    DataFetcher<List<Order>> getUerOrderByEmailQuery();

    DataFetcher<List<Order>> getAllOrdersByQuery();

    DataFetcher<List<Order>> getUserOrderByEmailQuery();

    DataFetcher<List<Order>> getUserOrdersByEmailQuery();
}
