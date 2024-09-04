package com.lamkadam.orderservice.modul;

import com.lamkadam.orderservice.enumes.ProductEtat;
import com.lamkadam.orderservice.enumes.ProductGestion;
import com.lamkadam.orderservice.enumes.ProductNature;
import com.lamkadam.orderservice.enumes.ProductType;
import lombok.Data;

import java.util.Date;

@Data
public class Product {


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
