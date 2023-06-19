package com.example.promoprice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactsResponseDTO {

    private Integer id;
    private String chain;
    private double totalValuePrice;
    private Integer productCategory;
}
