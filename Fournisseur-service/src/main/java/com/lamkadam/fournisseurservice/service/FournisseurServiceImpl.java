package com.lamkadam.fournisseurservice.service;

import com.lamkadam.fournisseurservice.entities.Fournisseur;
import com.lamkadam.fournisseurservice.repository.FournisseurRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Transactional
@Slf4j
public class FournisseurServiceImpl  implements FournisseurService{



    private FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }


    @Override
    public void deleteFournisseur(int FOURNCODEINT) {

        Fournisseur fournisseur = fournisseurRepository.findById(FOURNCODEINT).orElse(null);
        fournisseurRepository.delete(fournisseur);
    }
}
