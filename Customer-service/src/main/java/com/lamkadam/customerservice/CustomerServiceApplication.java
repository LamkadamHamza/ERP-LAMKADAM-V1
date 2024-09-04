package com.lamkadam.customerservice;

import com.lamkadam.customerservice.entities.Customer;
import com.lamkadam.customerservice.enums.GenreCustomer;
import com.lamkadam.customerservice.repository.CustomerRepository;
import com.lamkadam.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
                            .lastname("lamkadam")
                            .Email("hamza.lamkadam@gmail.com")
                            .DateNaissance(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .genre(GenreCustomer.MALE)
                             .build(),
                    Customer.builder()
                            .firstname("nabil")
                            .lastname("lamkadam")
                            .Email("nabil.lamkadam@gmail.com")
                            .DateNaissance(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .genre(GenreCustomer.MALE)
                            .build(),

                    Customer.builder()
                            .firstname("samira")
                            .lastname("lamkadam")
                            .Email("samira.lamkadam@gmail.com")
                            .DateNaissance(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .genre(GenreCustomer.FEMALE)
                            .build(),

                    Customer.builder()
                            .firstname("latifa")
                            .lastname("khoulaki")
                            .Email("latifa.khoulaki@gmail.com")
                            .DateNaissance(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .genre(GenreCustomer.FEMALE)
                            .build(),


                    Customer.builder()
                            .firstname("najib")
                            .lastname("sami")
                            .Email("najib.sami@gmail.com")
                            .DateNaissance(LocalDate.parse("21/8/2024", DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .genre(GenreCustomer.MALE)
                            .build()
            );


            customerRepository.saveAll(customerList);


                    };
    }
}
