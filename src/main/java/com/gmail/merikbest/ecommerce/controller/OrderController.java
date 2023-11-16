package com.gmail.merikbest.ecommerce.controller;

import com.gmail.merikbest.ecommerce.dto.GraphQLRequest;
import com.gmail.merikbest.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest.ecommerce.dto.order.OrderItemResponse;
import com.gmail.merikbest.ecommerce.dto.order.OrderRequest;
import com.gmail.merikbest.ecommerce.dto.order.OrderResponse;
import com.gmail.merikbest.ecommerce.mapper.OrderMapper;
import com.gmail.merikbest.ecommerce.security.UserPrincipal;
import com.gmail.merikbest.ecommerce.service.graphql.GraphQLProvider;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;

import static com.gmail.merikbest.ecommerce.constants.PathConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_ORDER)
public class OrderController {

    private final OrderMapper orderMapper;
    private final GraphQLProvider graphQLProvider;

    @GetMapping(ORDER_ID)
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderMapper.getOrderById(orderId));
    }

    @GetMapping(ORDER_ID_ITEMS)
    public ResponseEntity<List<OrderItemResponse>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderMapper.getOrderItemsByOrderId(orderId));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getUserOrders(@AuthenticationPrincipal UserPrincipal user,
                                                             @PageableDefault(size = 10) Pageable pageable) {
        HeaderResponse<OrderResponse> response = orderMapper.getUserOrders(user.getEmail(), (org.springframework.data.domain.Pageable) pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<OrderResponse> postOrder(@Valid @RequestBody OrderRequest order, BindingResult bindingResult) {
        return ResponseEntity.ok(orderMapper.postOrder(order, bindingResult));
    }

    @PostMapping(GRAPHQL)
    public ResponseEntity<ExecutionResult> getUserOrdersByQuery(@RequestBody GraphQLRequest request) {
        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    }
}
