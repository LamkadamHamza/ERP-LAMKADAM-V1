package com.lamkadam.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class Fournisseur {

    private int FOURNCODEINT;
    private int FOURNCODEEXT;
    private String FOURLIBL;
    private FournisseurEtat FOURETAT;
    private FournisseurType FOURTYPE;
    private FournisseurNature FOURNATU;
    private int FOURTAXE;
    private int FOURTVA;
    private Date FOURCRE;
    private Date FOURMAJ;
    private String FOURUTIL;
}
