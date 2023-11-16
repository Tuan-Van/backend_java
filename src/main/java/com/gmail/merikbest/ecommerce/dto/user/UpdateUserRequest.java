package com.gmail.merikbest.ecommerce.dto.user;

import com.gmail.merikbest.ecommerce.dto.PasswordResetRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import static com.gmail.merikbest.ecommerce.constants.ErrorMessage.*;

@Data
public class UpdateUserRequest {
    private Long id;

    @NotBlank(message = EMPTY_FIRST_NAME)
    private String firstName;

    @NotBlank(message = EMPTY_LAST_NAME)
    private String lastName;

    private String city;
    private String address;
    private String phoneNumber;
    private String postIndex;
}
