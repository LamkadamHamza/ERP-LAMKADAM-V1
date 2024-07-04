package com.lamkadam.customerservice;

import com.lamkadam.customerservice.entities.Customer;
import com.lamkadam.customerservice.repository.CustomerRepository;
import com.lamkadam.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return  args -> {
            List<Customer> customerList = List.of(Customer.builder()
                            .firstname("hamza")
                            .lastname("lam")
                            .Email("hamza.lam@gmail.com")
                             .build(),
                    Customer.builder()
                            .firstname("nabil")
                            .lastname("lam")
                            .Email("nabil.lam@gmail.com")
                            .build());

            customerRepository.saveAll(customerList);


                    };
    }
}
