package com.gmail.merikbest.ecommerce.dto.perfume;

import lombok.Data;

import java.util.List;

@Data
public class PerfumeSearchRequest {
    private List<String> perfumers;
    private List<String > genders;
    private List<Integer> price;
    private Boolean sortByPrice;
    private String perfumer;
    private String perfumeGender;
}
