package com.lamkadam.customerservice.dtos;

import com.lamkadam.customerservice.enums.GenreCustomer;
import lombok.*;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class CustomerDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private String Email;

    private LocalDate DateNaissance;

    private GenreCustomer genre;
}
