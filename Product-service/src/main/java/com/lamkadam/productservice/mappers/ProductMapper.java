package com.lamkadam.productservice.mappers;

import com.lamkadam.productservice.dtos.ProductDTO;
import com.lamkadam.productservice.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    ModelMapper modelMapper = new ModelMapper();

    public ProductDTO from (Product product){
        return  modelMapper.map(product , ProductDTO.class);
    }

    public Product from (ProductDTO productDTO){
        return  modelMapper.map(productDTO , Product.class);
    }


}
