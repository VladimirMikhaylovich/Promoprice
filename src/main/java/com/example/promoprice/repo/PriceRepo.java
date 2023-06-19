package com.example.promoprice.repo;

import com.example.promoprice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepo extends JpaRepository<Price, Integer> {
}
