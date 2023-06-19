package com.example.promoprice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "facts")
@Setter
@Getter
@NoArgsConstructor
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Date")
    private LocalDate dateOfSail;

    @Column(name = "Actual_Sales_Value")
    private double totalValuePrice;

    @Column(name = "Volume")
    private Integer volume;

    @Column(name = "Chain")
    private String chain;


    @Column(name = "Type")
    private String type;

    @Column(name = "promo_share")
    private Double promoShare;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CH3_Ship_To_Code")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Material_No")
    private Product product;

    public Fact(LocalDate dateOfSail, double totalValuePrice, Integer volume, String chain, Customer customer, Product product) {
        this.dateOfSail = dateOfSail;
        this.totalValuePrice = totalValuePrice;
        this.volume = volume;
        this.chain = chain;
        this.customer = customer;
        this.product = product;
        this.promoShare = getPromoShare();
        this.type = getTypes();

    }

    private String getTypes(){
        Price price = product.getPrice();
        double costOfProduct = price.getStandardPrice();
        double checkPrice = totalValuePrice/volume;
        if(checkPrice<costOfProduct){
            type = "Promo";
        } else {
            type = "Regular";
        }
        return type;
    }
    private Double getPromoShare(){
        if(type.equals("Promo")){
            Price price = product.getPrice();
            double costOfProduct = price.getStandardPrice()*volume;
            double promoShare = (totalValuePrice-costOfProduct)*100;
            return promoShare;
        }
        return 0.0;
    }

}

