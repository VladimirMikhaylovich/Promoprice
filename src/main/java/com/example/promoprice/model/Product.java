package com.example.promoprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
public class Product {

    @Id
    @Column(name = "Material_No")
    private Integer productCode;

    @Column(name = "Material_Desc_RUS")
    private String productName;
    @Column(name = "L3_Product_Category_Code")
    private Integer productCategory;
    @Column(name = "L3_Product_Category_Name")
    private String productBrand;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private Price price;

    public Product() {
    }

    public Product(String productName, int productCategory, String productBrand, Price price) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.price = price;
    }




    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", productBrand='" + productBrand + '\'' +
                ", price=" + price +
                '}';
    }
}
