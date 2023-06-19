package com.example.promoprice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Chain_name")
    private String nameOfChain;

    @Column(name = "Regular_price_per_unit")
    private Double standardPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Material_No")
    private Product product;


    public Price(String nameOfChain, Double standardPrice, Product product) {
        this.nameOfChain = nameOfChain;
        this.standardPrice = standardPrice;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfChain() {
        return nameOfChain;
    }

    public void setNameOfChain(String nameOfChain) {
        this.nameOfChain = nameOfChain;
    }

    public Double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(Double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
