package com.example.promoprice.web;

import com.example.promoprice.model.Price;
import com.example.promoprice.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")

public class PriceController {

    PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Price>> getAllPrices() {
        return ResponseEntity.ok(priceService.getAllPrices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Integer id) {
        return ResponseEntity.ok(priceService.getPriceById(id));
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> creatPrice(@RequestBody Price price) {
        priceService.create(price);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePrice(@PathVariable Integer id) {
        priceService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Integer id, @RequestBody Price price) {
        return ResponseEntity.ok(priceService.updatePriceById(id, price));
    }

}
