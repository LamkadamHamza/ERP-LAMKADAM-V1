package com.lamkadam.orderservice.entities;

import com.lamkadam.orderservice.enumes.StatusOrder;
import com.lamkadam.orderservice.modul.Customer;
import com.lamkadam.orderservice.modul.Product;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ToString @Builder
@Table(name = "orders")
public class Order {

    @Id
    private String id ;
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateLivrision;
    private LocalDate dateReception;
    private StatusOrder status;
    private String Contratfile;
    private  Long IdCustomer;
    @Transient
    private Customer customer;
    private  String IdProduct;
    @Transient
    private Product product;

    private Long IdSite;

    @PrePersist
    protected void onCreate() {
        this.dateCreation = new Date(); // Initialise la date de création avec la date actuelle
    }


}
