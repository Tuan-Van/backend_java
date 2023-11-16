package com.gmail.merikbest.ecommerce.dto.auth;

import com.gmail.merikbest.ecommerce.dto.user.UserResponse;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
}
