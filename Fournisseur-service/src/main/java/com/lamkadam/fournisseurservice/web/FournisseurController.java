package com.lamkadam.fournisseurservice.web;

import com.lamkadam.fournisseurservice.entities.Fournisseur;
import com.lamkadam.fournisseurservice.repository.FournisseurRepository;
import com.lamkadam.fournisseurservice.service.FournisseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FournisseurController {

    private FournisseurRepository fournisseurRepository;
    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurRepository fournisseurRepository, FournisseurService fournisseurService) {
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurService = fournisseurService;
    }


    @GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFourniseur(){
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        return fournisseurs;
    }


    @DeleteMapping("/fournisseurs/{id}")
    public void DeleteFournisseur(@PathVariable int id)  {
       fournisseurService.deleteFournisseur(id);

    }

}
