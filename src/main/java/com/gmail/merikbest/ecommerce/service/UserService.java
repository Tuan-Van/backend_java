package com.gmail.merikbest.ecommerce.service;

import com.gmail.merikbest.ecommerce.domain.Perfume;
import com.gmail.merikbest.ecommerce.domain.User;
import graphql.schema.DataFetcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User getUserById(Long userId);

    User getUserInfo(String email);

    Page<User> getAllUsers(Pageable pageable);

    List<Perfume> getCart(List<Long> perfumeIds);

    User updateUserInfo(String email, User user);

    DataFetcher<List<User>> getAllUserByQuery();

    DataFetcher<User> getUserByQuery();
}
