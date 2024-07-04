package com.lamkadam.billingservice.entities;

import com.lamkadam.billingservice.modul.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ToString @Builder
public class Bill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate billingDate;
    private long customerID;
    @OneToMany(mappedBy ="bill")
    private Collection<ProductItem> productItems;

    @Transient
    private Customer customer;


}
