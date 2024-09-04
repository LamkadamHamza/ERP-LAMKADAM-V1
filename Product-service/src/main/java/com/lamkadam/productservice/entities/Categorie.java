package com.lamkadam.productservice.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Categorie {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Product> products;


}
