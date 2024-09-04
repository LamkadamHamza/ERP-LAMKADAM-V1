package com.lamkadam.fournisseurservice.service;

import com.lamkadam.fournisseurservice.entities.Fournisseur;

public interface FournisseurService {


    void deleteFournisseur(int FOURNCODEINT) ;

    Fournisseur findfournisseurById(int code);
}
