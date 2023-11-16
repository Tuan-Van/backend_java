package com.gmail.merikbest.ecommerce.controller;

import com.gmail.merikbest.ecommerce.dto.GraphQLRequest;
import com.gmail.merikbest.ecommerce.dto.perfume.PerfumeRequest;
import com.gmail.merikbest.ecommerce.dto.perfume.PerfumeResponse;
import com.gmail.merikbest.ecommerce.dto.user.UpdateUserRequest;
import com.gmail.merikbest.ecommerce.dto.user.UserResponse;
import com.gmail.merikbest.ecommerce.mapper.UserMapper;
import com.gmail.merikbest.ecommerce.repository.UserRepository;
import com.gmail.merikbest.ecommerce.security.UserPrincipal;
import com.gmail.merikbest.ecommerce.service.graphql.GraphQLProvider;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.gmail.merikbest.ecommerce.constants.PathConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_USERS)
public class UserController {

    private final UserMapper userMapper;
    private final GraphQLProvider graphQLProvider;

    @GetMapping
    public ResponseEntity<UserResponse> getUserInfo(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(userMapper.getUserInfo(user.getEmail()));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUserInfo(@AuthenticationPrincipal UserPrincipal user,
                                                       @Valid @RequestBody UpdateUserRequest request,
                                                       BindingResult bindingResult) {
       return ResponseEntity.ok(userMapper.updateUserInfo(user.getEmail(), request, bindingResult));
    }

    @PostMapping(CART)
    public ResponseEntity<List<PerfumeResponse>> getCart(@RequestBody List<Long> perfumesIds) {
        return ResponseEntity.ok(userMapper.getCart(perfumesIds));
    }

    @PostMapping(GRAPHQL)
    public ResponseEntity<ExecutionResult> getUserInfoByQuery(@RequestBody GraphQLRequest request) {
        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    }
}
