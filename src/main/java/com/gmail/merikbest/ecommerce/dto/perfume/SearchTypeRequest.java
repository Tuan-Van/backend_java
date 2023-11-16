package com.gmail.merikbest.ecommerce.dto.perfume;

import com.gmail.merikbest.ecommerce.enums.SearchPerfume;
import lombok.Data;

@Data
public class SearchTypeRequest {
    private SearchPerfume searchType;
    private String text;
}
