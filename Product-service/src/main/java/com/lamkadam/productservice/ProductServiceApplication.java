package com.lamkadam.productservice;

import com.lamkadam.productservice.entities.Product;
import com.lamkadam.productservice.enums.ProductEtat;
import com.lamkadam.productservice.enums.ProductGestion;
import com.lamkadam.productservice.enums.ProductNature;
import com.lamkadam.productservice.enums.ProductType;
import com.lamkadam.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return  args -> {
            List<Product> productList =  List.of(Product.builder()
                            .id("1")
                            .name("AAAA")
                            .PRODCINT(1990)
                            .PRODCEXT("12345")
                            .productEtat(ProductEtat.ACTIVE)
                            .productGestion(ProductGestion.DEFAUT)
                            .productNature(ProductNature.DEFAUT)
                            .productType(ProductType.USUELLE)
                            .PRODDCRE(new Date())

                            .price(Math.random()*100)
                            .quantity(2).
                             build(),
                            Product.builder().
                            id("2")
                            .name("BBBB")

                                    .PRODCINT(1999)
                                    .PRODCEXT("17568)")
                                    .productEtat(ProductEtat.ACTIVE)
                                    .productGestion(ProductGestion.DEFAUT)
                                    .productNature(ProductNature.DEFAUT)
                                    .productType(ProductType.SERVICE)
                                    .PRODDCRE(new Date())
                            .price(Math.random()*200)
                            .quantity(4).
                              build(),
                    Product.builder().
                            id("3")
                            .name("CCCC")
                            .PRODCINT(2020)
                            .PRODCEXT("89076")
                            .productEtat(ProductEtat.GELE)
                            .productGestion(ProductGestion.DEFAUT)
                            .productNature(ProductNature.ALIMENTAIRE)
                            .productType(ProductType.USUELLE)
                            .PRODDCRE(new Date())
                            .price(Math.random()*67)
                            .quantity(10).
                            build(),
                    Product.builder().
                            id("4")
                            .name("DDDD")
                            .PRODCINT(2060)
                            .PRODCEXT("90675")
                            .productEtat(ProductEtat.GELEACHAT)
                            .productGestion(ProductGestion.PGC)
                            .productNature(ProductNature.DEFAUT)
                            .productType(ProductType.USUELLE)
                            .PRODDCRE(new Date())
                            .price(Math.random()*80)
                            .quantity(14).
                            build()
            );

            productRepository.saveAll(productList);

                               };
    }
}
