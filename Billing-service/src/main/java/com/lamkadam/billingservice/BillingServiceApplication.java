package com.lamkadam.billingservice;

import com.lamkadam.billingservice.FeignClient.CustomerServiceClient;
import com.lamkadam.billingservice.FeignClient.ProductServiceClient;
import com.lamkadam.billingservice.entities.Bill;
import com.lamkadam.billingservice.entities.ProductItem;
import com.lamkadam.billingservice.modul.Customer;
import com.lamkadam.billingservice.repository.BillRepository;
import com.lamkadam.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerServiceClient customerServiceClient,
                                        ProductServiceClient productServiceClient
                                        )
    {
        return args -> {





            customerServiceClient.allCustomers().forEach(c->{

                List<ProductItem> productItems = new ArrayList<>();


                Bill bill1 =  Bill.builder()
                        .billingDate(LocalDate.now())
                        .customerID(c.getId())
                        .productItems(productItems)
                        .build();


                Bill savedBill =  billRepository.save(bill1);


                productServiceClient.allProduct().forEach(p->{
                    ProductItem productItem1 =ProductItem.builder()
                            .productId(p.getId())
                            .price(1000)
                            .quantity(Math.random()*100)
                            .bill(savedBill)
                            .build();

                    productItemRepository.save(productItem1);
                    productItems.add(productItem1);

                    ProductItem productItem2 =ProductItem.builder()
                            .productId(p.getId())
                            .price(800)
                            .quantity(Math.random()*199)
                            .bill(savedBill)
                            .build();

                    productItemRepository.save(productItem2);
                    productItems.add(productItem2);
                });


                savedBill.setProductItems(productItems);
                billRepository.save(savedBill);
            });

        };
    }





}
