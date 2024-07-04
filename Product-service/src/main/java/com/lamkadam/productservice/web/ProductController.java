package com.lamkadam.productservice.web;


import com.lamkadam.productservice.dtos.ProductDTO;
import com.lamkadam.productservice.entities.Product;
import com.lamkadam.productservice.exceptions.ProductAlreadyExistException;
import com.lamkadam.productservice.exceptions.ProductNotFoundException;
import com.lamkadam.productservice.mappers.ProductMapper;
import com.lamkadam.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;




   @GetMapping("/products")
    public List<Product> getAllProduct (){
        List<ProductDTO> productDTOS = productService.GetListProduct();

        List<Product> products = productDTOS.stream()
                .map(productMapper::from)
                .collect(Collectors.toList());
        return products;
    }


    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) throws ProductAlreadyExistException {
      ProductDTO productDTO =productMapper.from(product);
      ProductDTO saveProd =productService.save(productDTO);
      Product productseved = productMapper.from(saveProd);
       return productseved;
    }


    @GetMapping("/products/{id}")
    public  Product getProductById(@PathVariable String id) throws ProductNotFoundException {
       ProductDTO productDTO =productService.GetProductById(id);
       Product product = productMapper.from(productDTO);
       return product;
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product , @PathVariable String id) throws ProductNotFoundException, ProductAlreadyExistException {
       ProductDTO productDTO =productService.GetProductById(id);
       ProductDTO productDTOUpdate = productService.UpdateProduct(productDTO);
       Product productUpdate = productMapper.from(productDTOUpdate);
       return productUpdate;
    }

    @DeleteMapping("/products/{id}")
    public void DeleteProduct(@PathVariable String id) throws ProductNotFoundException {

        productService.deleteProduct(id);
    }
}
