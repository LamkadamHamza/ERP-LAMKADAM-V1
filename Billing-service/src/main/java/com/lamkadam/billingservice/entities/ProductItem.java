package com.lamkadam.billingservice.entities;


import com.lamkadam.billingservice.modul.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class ProductItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double price;

    private double quantity;

   @ManyToOne
   private Bill bill;
    @Transient
    private Product product;




}
