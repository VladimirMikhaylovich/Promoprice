package com.example.promoprice.web;

import com.example.promoprice.model.Fact;
import com.example.promoprice.model.Product;
import com.example.promoprice.model.TypeOfPrice;
import com.example.promoprice.model.dto.FactsResponseDTO;
import com.example.promoprice.service.FactsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/analyses")
public class FactsController {

    FactsService factsService;

    public FactsController(FactsService factsService) {
        this.factsService = factsService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Fact>> getAllFacts() {
        return ResponseEntity.ok(factsService.getAllFacts());

    }

    @GetMapping("/{date}/{chain}")
    public ResponseEntity<List<Fact>> getFactsByDateAndChain(@PathVariable @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable String chain) {
        return ResponseEntity.ok(factsService.getFactByDateOfSailAndChain(date, chain));
    }

    @GetMapping("/product/{date}/")
    public ResponseEntity<List<Fact>> getFactsByDateAndChain(@PathVariable @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody Product product) {
        return ResponseEntity.ok(factsService.getFactByDateOfSailAndProduct(date, product));
    }

    @GetMapping("/type/{type}/{date}")
    public ResponseEntity<List<FactsResponseDTO>> getFactByType(@PathVariable String type, @PathVariable @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok((factsService.getFactByTypeAndDate(type, date)));
    }
}
