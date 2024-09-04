package com.lamkadam.productservice.dtos;

import com.lamkadam.productservice.entities.Categorie;
import com.lamkadam.productservice.enums.ProductEtat;
import com.lamkadam.productservice.enums.ProductGestion;
import com.lamkadam.productservice.enums.ProductNature;
import com.lamkadam.productservice.enums.ProductType;
import com.lamkadam.productservice.model.Fournisseur;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class ProductDTO {

    private String id;
    private String name ;
    private int PRODCINT;
    private String PRODCEXT;
    private ProductType productType;
    private ProductNature productNature ;
    private ProductEtat productEtat;
    private ProductGestion productGestion;
    private Date PRODDCRE;
    private  CategorieDTO categorieDTO;


    private double price ;

  private int quantity ;




    private Fournisseur fournisseur;
    private int FOURNCODEINT;
}
