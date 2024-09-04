package com.lamkadam.customerservice.entities;


import com.lamkadam.customerservice.enums.GenreCustomer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor  @ToString @Builder
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String Email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate DateNaissance;

   private GenreCustomer genre;
}
