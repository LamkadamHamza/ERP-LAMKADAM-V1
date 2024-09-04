package com.lamkadam.productservice.clients;


import com.lamkadam.productservice.model.Fournisseur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FOURNISSEUR-SERVICE")
public interface FournisseurRestClient {

    @GetMapping("/api/fournisseurs")
    List<Fournisseur> allFournissuer();



    @GetMapping("/api/fournisseurs/{id}")
    Fournisseur findFournisseurById(@PathVariable Long id);
}
