package com.lamkadam.productservice.dtos;


import com.lamkadam.productservice.entities.Product;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CategorieDTO {

    private Long id;
    private String  name;

   /* private List<ProductDTO> products;*/
}
