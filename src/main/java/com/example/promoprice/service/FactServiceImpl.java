package com.example.promoprice.service;

import com.example.promoprice.model.Fact;
import com.example.promoprice.model.Product;
import com.example.promoprice.model.dto.FactsResponseDTO;
import com.example.promoprice.repo.FactRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FactServiceImpl implements FactsService {

    FactRepo factRepo;

    public FactServiceImpl(FactRepo factRepo) {
        this.factRepo = factRepo;
    }


    @Override
    public List<Fact> getAllFacts() {
        return factRepo.findAll();
    }

    @Override
    public List<Fact> getFactByDateOfSailAndChain(LocalDate date, String chain) {
        return factRepo.getFactByDateOfSailAndChain(date, chain);
    }

    @Override
    public List<Fact> getFactByDateOfSailAndProduct(LocalDate date, Product product) {
        return factRepo.getFactByDateOfSailAndProduct(date, product);
    }

    @Override
    public List<FactsResponseDTO> getFactByTypeAndDate(String type, LocalDate date) {
        return factRepo.getFactByTypeAndDate(type, date);
    }
}
