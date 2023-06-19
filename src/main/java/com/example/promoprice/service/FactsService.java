package com.example.promoprice.service;

import com.example.promoprice.model.Fact;
import com.example.promoprice.model.Product;
import com.example.promoprice.model.dto.FactsResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface FactsService {


    List<Fact> getAllFacts();

    List<Fact> getFactByDateOfSailAndChain(LocalDate date, String chain);

    List<Fact> getFactByDateOfSailAndProduct(LocalDate date, Product product);

    List<FactsResponseDTO> getFactByTypeAndDate(String type, LocalDate date);

}
