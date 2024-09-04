package com.lamkadam.productservice.service;

import com.lamkadam.productservice.dtos.ProductDTO;
import com.lamkadam.productservice.exceptions.ProductAlreadyExistException;
import com.lamkadam.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO request) throws ProductAlreadyExistException;

    List<ProductDTO> GetListProduct();

    ProductDTO GetProductById(String id) throws ProductNotFoundException;

    ProductDTO UpdateProduct(ProductDTO productDTO) throws ProductNotFoundException ,ProductAlreadyExistException;

    void deleteProduct(String id) throws  ProductNotFoundException;

    List<ProductDTO>  findProduct(String kw);

    public ProductDTO assignCategoryToProduct(String productId, Long categoryId);

}
