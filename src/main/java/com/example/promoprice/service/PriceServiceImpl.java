package com.example.promoprice.service;

import com.example.promoprice.model.Price;
import com.example.promoprice.repo.PriceRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    private PriceRepo priceRepo;

    public PriceServiceImpl(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    @Override
    @Transactional
    public void create(Price price) {
        Optional<Price> optional = priceRepo.findById(price.getId());
        Price newPrice = (optional.isPresent()) ? optional.get() : null;
        priceRepo.save(price);
    }

    @Override
    public List<Price> getAllPrices() {
        return priceRepo.findAll();
    }

    @Override
    public Price getPriceById(Integer id) {
        Optional<Price> optional = priceRepo.findById(id);
        Price price = (optional.isPresent()) ? optional.get() : null;
        return price;
    }

    @Override
    @Transactional
    public Price updatePriceById(Integer id, Price price) {
        Optional<Price> optional = priceRepo.findById(id);
        Price priceToUpd = (optional.isPresent()) ? optional.get() : null;
        priceToUpd.setStandardPrice(price.getStandardPrice());
        priceToUpd.setProduct(price.getProduct());
        priceToUpd.setNameOfChain(price.getNameOfChain());
        priceRepo.save(priceToUpd);
        return priceToUpd;
    }

    @Override
    public void deleteById(Integer id) {
        priceRepo.deleteById(id);
    }
}
