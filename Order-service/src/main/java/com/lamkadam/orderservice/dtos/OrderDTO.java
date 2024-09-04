package com.lamkadam.orderservice.dtos;

import com.lamkadam.orderservice.enumes.StatusOrder;
import com.lamkadam.orderservice.modul.Customer;
import com.lamkadam.orderservice.modul.Product;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class OrderDTO {

    private String id ;
    private Date dateCreation;
    private LocalDate dateLivrision;
    private LocalDate dateReception;
    private StatusOrder status;
    private String Contratfile;
    private  Long IdCustomer;
    private Customer customer;
    private  String IdProduct;
    private Product product;
    private Long IdSite;


}
