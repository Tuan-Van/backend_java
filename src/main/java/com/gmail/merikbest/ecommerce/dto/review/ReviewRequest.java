package com.gmail.merikbest.ecommerce.dto.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.gmail.merikbest.ecommerce.constants.ErrorMessage.*;

@Data
public class ReviewRequest {
    private Long perfumeId;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD )
    private String author;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String message;

    @NotNull(message = "Choose perfume rating")
    private Integer rating;
}
