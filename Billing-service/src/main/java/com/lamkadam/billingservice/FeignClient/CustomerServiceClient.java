package com.lamkadam.billingservice.FeignClient;

import com.lamkadam.billingservice.modul.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Customer-service")
public interface CustomerServiceClient {

    @GetMapping("/api/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    List<Customer> allCustomers();
}