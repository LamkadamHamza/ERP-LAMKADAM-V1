package com.lamkadam.productservice.entities;

import com.lamkadam.productservice.enums.ProductEtat;
import com.lamkadam.productservice.enums.ProductGestion;
import com.lamkadam.productservice.enums.ProductNature;
import com.lamkadam.productservice.enums.ProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class Product {


    @Id
    private String id;
    private String name ;
    private int PRODCINT;
    private String PRODCEXT;
    private ProductType productType;
    private ProductNature productNature ;
    private ProductEtat productEtat;
    private ProductGestion productGestion;
    private Date PRODDCRE;
    private Date PRODDMAJ;
    private double price ;
    private int quantity ;
}
