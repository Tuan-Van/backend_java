package com.gmail.merikbest.ecommerce.dto.user;

import com.gmail.merikbest.ecommerce.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BaseUserResponse {
    private Long id;
    private String email;
    private String firstName;
    private Set<Role> roles;
    private String provider;
}
