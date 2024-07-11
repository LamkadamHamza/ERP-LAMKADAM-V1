package com.lamkadam.fournisseurservice.web;

import com.lamkadam.fournisseurservice.entities.Fournisseur;
import com.lamkadam.fournisseurservice.repository.FournisseurRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FournisseurController {

    private FournisseurRepository fournisseurRepository;

    public FournisseurController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }


    @GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFourniseur(){
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        return fournisseurs;
    }
}
