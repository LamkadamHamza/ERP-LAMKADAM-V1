package com.lamkadam.productservice;

import com.lamkadam.productservice.clients.FournisseurRestClient;
import com.lamkadam.productservice.entities.Categorie;
import com.lamkadam.productservice.entities.Product;
import com.lamkadam.productservice.enums.ProductEtat;
import com.lamkadam.productservice.enums.ProductGestion;
import com.lamkadam.productservice.enums.ProductNature;
import com.lamkadam.productservice.enums.ProductType;
import com.lamkadam.productservice.model.Fournisseur;
import com.lamkadam.productservice.repository.CategorieRepository;
import com.lamkadam.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository ,
                                        CategorieRepository categorieRepository,
                                        FournisseurRestClient fournisseurRestClient) {
        return args -> {


            Categorie electronics = new Categorie();
            electronics.setName("Electronics");

            Categorie groceries = new Categorie();
            groceries.setName("Groceries");

            categorieRepository.saveAll(List.of(electronics, groceries));

            List<Fournisseur> fournisseurList = fournisseurRestClient.allFournissuer();




                Product product1 =Product.builder()
                        .id(UUID.randomUUID().toString())
                        .name("AAAA")
                        .PRODCINT(1990)
                        .PRODCEXT("12345")
                        .productEtat(ProductEtat.ACTIVE)
                        .productGestion(ProductGestion.DEFAUT)
                        .productNature(ProductNature.DEFAUT)
                        .productType(ProductType.USUELLE)
                        .PRODDCRE(new Date())
                        .price(Math.random() * 100)
                        .quantity(2)
                        .categorie(electronics)
                        .fournisseur(fournisseurList.get(0))
                        .FOURNCODEINT(fournisseurList.get(0).getFOURNCODEINT())
                        .build();

                Product product2 =Product.builder()
                        .id(UUID.randomUUID().toString())
                        .name("BBBB")

                        .PRODCINT(1999)
                        .PRODCEXT("17568)")
                        .productEtat(ProductEtat.ACTIVE)
                        .productGestion(ProductGestion.DEFAUT)
                        .productNature(ProductNature.DEFAUT)
                        .productType(ProductType.SERVICE)
                        .PRODDCRE(new Date())
                        .price(Math.random() * 200)
                        .quantity(4)
                        .categorie(groceries)
                        .fournisseur(fournisseurList.get(1))
                        .FOURNCODEINT(fournisseurList.get(1).getFOURNCODEINT())
                        .build();

            Product product3 = Product.builder().
                    id(UUID.randomUUID().toString())
                    .name("CCCC")
                    .PRODCINT(2020)
                    .PRODCEXT("89076")
                    .productEtat(ProductEtat.GELE)
                    .productGestion(ProductGestion.DEFAUT)
                    .productNature(ProductNature.ALIMENTAIRE)
                    .productType(ProductType.USUELLE)
                    .PRODDCRE(new Date())
                    .price(Math.random() * 67)
                    .quantity(10).
                    categorie(electronics)
                    .fournisseur(fournisseurList.get(2))
                    .FOURNCODEINT(fournisseurList.get(2).getFOURNCODEINT()).
                    build();

            Product product4 = Product.builder().
                    id(UUID.randomUUID().toString())
                    .name("DDDD")
                    .PRODCINT(2060)
                    .PRODCEXT("90675")
                    .productEtat(ProductEtat.GELEACHAT)
                    .productGestion(ProductGestion.PGC)
                    .productNature(ProductNature.DEFAUT)
                    .productType(ProductType.USUELLE)
                    .PRODDCRE(new Date())
                    .price(Math.random() * 80)
                    .quantity(14).categorie(groceries)
                    .fournisseur(fournisseurList.get(3))
                    .FOURNCODEINT(fournisseurList.get(3).getFOURNCODEINT())
                    .build();




            productRepository.save(product1);
                productRepository.save(product2);
                productRepository.save(product3);
            productRepository.save(product4);


            /*fournisseurRestClient.allFournissuer().forEach(f -> {
                Product product1 = Product.builder()
                        .id("1")
                        .name("AAAA")
                        .PRODCINT(1990)
                        .PRODCEXT("12345")
                        .productEtat(ProductEtat.ACTIVE)
                        .productGestion(ProductGestion.DEFAUT)
                        .productNature(ProductNature.DEFAUT)
                        .productType(ProductType.USUELLE)
                        .PRODDCRE(new Date())
                        .price(Math.random() * 100)
                        .quantity(2)
                        .categorie(electronics)
                        .fournisseur(f)
                        .FOURNCODEINT(f.getFOURNCODEINT())

                        .build();

                Product product2 = Product.builder().
                        id("2")
                        .name("BBBB")

                        .PRODCINT(1999)
                        .PRODCEXT("17568)")
                        .productEtat(ProductEtat.ACTIVE)
                        .productGestion(ProductGestion.DEFAUT)
                        .productNature(ProductNature.DEFAUT)
                        .productType(ProductType.SERVICE)
                        .PRODDCRE(new Date())
                        .price(Math.random() * 200)
                        .quantity(4)
                        .categorie(groceries)
                        .fournisseur(f)
                        .FOURNCODEINT(f.getFOURNCODEINT())
                        .build();

                Product product3 = Product.builder().
                        id("3")
                        .name("CCCC")
                        .PRODCINT(2020)
                        .PRODCEXT("89076")
                        .productEtat(ProductEtat.GELE)
                        .productGestion(ProductGestion.DEFAUT)
                        .productNature(ProductNature.ALIMENTAIRE)
                        .productType(ProductType.USUELLE)
                        .PRODDCRE(new Date())
                        .price(Math.random() * 67)
                        .quantity(10).
                        categorie(electronics)
                         .fournisseur(f)
                        .FOURNCODEINT(f.getFOURNCODEINT()).
                        build();
                Product product4 = Product.builder().
                        id("4")
                        .name("DDDD")
                        .PRODCINT(2060)
                        .PRODCEXT("90675")
                        .productEtat(ProductEtat.GELEACHAT)
                        .productGestion(ProductGestion.PGC)
                        .productNature(ProductNature.DEFAUT)
                        .productType(ProductType.USUELLE)
                        .PRODDCRE(new Date())
                        .price(Math.random() * 80)
                        .quantity(14).categorie(groceries)
                        .fournisseur(f)
                        .FOURNCODEINT(f.getFOURNCODEINT())
                        .build();

                productRepository.save(product1);
                productRepository.save(product2);
                productRepository.save(product3);
                productRepository.save(product4);


            });*/

            /*List<Product> productList =  List.of(Product.builder()
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
                            .quantity(2)
                            .categorie(electronics)
                            .build(),
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
                            .quantity(4)
                                    .categorie(groceries)
                                    .build(),
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
                            categorie(electronics).
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
                            .quantity(14).categorie(groceries)

                            .build()
            );

            productRepository.saveAll(productList);

                               };
    }*/
        };
    }
}
