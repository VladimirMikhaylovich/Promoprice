package com.example.promoprice.repo;

import com.example.promoprice.model.Fact;
import com.example.promoprice.model.Product;
import com.example.promoprice.model.TypeOfPrice;
import com.example.promoprice.model.dto.FactsResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FactRepo extends JpaRepository<Fact, Integer> {

    List<Fact> getFactByDateOfSail(LocalDate date);
    List<Fact> getFactByDateOfSailAndChain(LocalDate date, String chain);

    List<Fact> getFactByDateOfSailAndProduct(LocalDate date, Product product);


    @Query("SELECT new com.example.promoprice.model.dto.FactsResponseDTO(f.id, f.chain, f.totalValuePrice, f.product.productCode)" +
            " FROM Fact f  WHERE f.type = :type and MONTH(f.dateOfSail) = MONTH( :date)")
    List<FactsResponseDTO> getFactByTypeAndDate (@Param("type") String type, @Param("date") LocalDate date);

}
