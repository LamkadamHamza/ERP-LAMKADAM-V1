package com.lamkadam.fournisseurservice.entities;


import com.lamkadam.fournisseurservice.enums.FournisseurEtat;
import com.lamkadam.fournisseurservice.enums.FournisseurNature;
import com.lamkadam.fournisseurservice.enums.FournisseurType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Fournisseur {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
