package com.lamkadam.billingservice.FeignClient;

import com.lamkadam.billingservice.modul.Customer;
import com.lamkadam.billingservice.modul.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Product-service")
public interface ProductServiceClient {

    @GetMapping("/api/products/{id}")
    Product findProductById(@PathVariable String id);

    @GetMapping("/api/products")
    List<Product> allProduct();
}
