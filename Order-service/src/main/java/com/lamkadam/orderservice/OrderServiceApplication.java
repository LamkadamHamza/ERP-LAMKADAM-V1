package com.lamkadam.orderservice;

import com.lamkadam.orderservice.clients.CustomerServiceClient;
import com.lamkadam.orderservice.clients.ProductServiceClient;
import com.lamkadam.orderservice.clients.SiteServiceClient;
import com.lamkadam.orderservice.entities.Order;
import com.lamkadam.orderservice.enumes.StatusOrder;
import com.lamkadam.orderservice.modul.Customer;
import com.lamkadam.orderservice.modul.Product;
import com.lamkadam.orderservice.modul.Site;
import com.lamkadam.orderservice.repository.OrderRepository;
import com.lamkadam.orderservice.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(OrderService orderService ,
                                        OrderRepository orderRepository,
                                        CustomerServiceClient customerServiceClient,
                                        ProductServiceClient productServiceClient,
                                        SiteServiceClient siteServiceClient){

        return args -> {

            List<Customer> customerList = customerServiceClient.allCustomers();
            List<Product>  productList = productServiceClient.allProducts();
            List<Site>  siteList = siteServiceClient.allSites();


                Order order1 = Order.builder()
                        .id(UUID.randomUUID().toString())
                        .dateLivrision(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))

                        .status(StatusOrder.CREATED)
                        .IdCustomer(customerList.get(0).getId())
                        .customer(customerList.get(0))
                        .IdProduct(productList.get(0).getId())
                        .IdSite(siteList.get(0).getId())
                        .build();



                Order order2 = Order.builder()
                        .id(UUID.randomUUID().toString())

                        .status(StatusOrder.CREATED)
                        .dateLivrision(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))
                        .IdCustomer(customerList.get(1).getId())
                        .customer(customerList.get(1))
                        .IdProduct(productList.get(1).getId())
                        .IdSite(siteList.get(1).getId())
                        .build();
                orderRepository.save(order1);
                orderRepository.save(order2);



        };
    }
}
