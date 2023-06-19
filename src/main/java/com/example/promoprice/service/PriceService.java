package com.example.promoprice.service;

import com.example.promoprice.model.Price;

import java.util.List;

public interface PriceService {

    void create(Price price);

    List<Price> getAllPrices();

    Price getPriceById(Integer id);

    Price updatePriceById(Integer id, Price price);

    void deleteById(Integer id);

}
