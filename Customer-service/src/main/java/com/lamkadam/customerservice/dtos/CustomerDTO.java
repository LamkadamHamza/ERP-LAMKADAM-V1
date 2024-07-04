package com.lamkadam.customerservice.dtos;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class CustomerDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private String Email;
}
