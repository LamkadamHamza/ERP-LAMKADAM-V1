package com.lamkadam.billingservice.web;


import com.lamkadam.billingservice.FeignClient.CustomerServiceClient;
import com.lamkadam.billingservice.FeignClient.ProductServiceClient;
import com.lamkadam.billingservice.entities.Bill;
import com.lamkadam.billingservice.entities.ProductItem;
import com.lamkadam.billingservice.modul.Customer;
import com.lamkadam.billingservice.modul.Product;
import com.lamkadam.billingservice.repository.BillRepository;
import com.lamkadam.billingservice.repository.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class BillRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    private CustomerServiceClient customerServiceClient;

    private ProductServiceClient productServiceClient;



    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer = customerServiceClient.findCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);

        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productServiceClient.findProductById(pi.getProductId()));
        });
        return bill; }



}
