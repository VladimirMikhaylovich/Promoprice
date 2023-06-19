package com.example.promoprice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "CH3_Ship_To_Code")
    private Integer id;

    @Column(name = "CH3_Ship_To_Name")
    private String shipToName;

    @Column(name = "Chain_name")
    private String nameOfChain;

}
