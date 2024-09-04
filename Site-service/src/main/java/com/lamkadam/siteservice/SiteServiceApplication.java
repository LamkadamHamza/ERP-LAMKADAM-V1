package com.lamkadam.siteservice;

import com.lamkadam.siteservice.entities.Site;
import com.lamkadam.siteservice.repository.SiteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SiteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(SiteRepository siteRepository){
        return args -> {
            Site site1 = Site.builder()
                    .name("ZARKTOUNI")
                    .address("ZARKTOUNUE RUE 91")
                    .email("M.Z@lamkadam.com")
                    .phoneNumber("0601844517")
                    .build();
            Site site2 = Site.builder()
                    .name("NAHDA")
                    .address("HAY NAHDA RUE 30 RABAT")
                    .email("M.N@lamkadam.com")
                    .phoneNumber("0601849053")
                    .build();
            Site site3 = Site.builder()
                    .name("GILIZ")
                    .address("GILIZ  RUE 29 MARAKECH")
                    .email("M.G@lamkadam.com")
                    .phoneNumber("060187086")
                    .build();

            Site site4= Site.builder()
                    .name("Mohmadia1")
                    .address("MANSMAR  RUE 29 MOUHMADIA")
                    .email("M.M@lamkadam.com")
                    .phoneNumber("060187086")
                    .build();

            siteRepository.save(site1);
            siteRepository.save(site2);
            siteRepository.save(site3);
            siteRepository.save(site4);
        };
    }
}
