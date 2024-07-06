package com.lamkadam.fournisseurservice.dtos;

import com.lamkadam.fournisseurservice.enums.FournisseurEtat;
import com.lamkadam.fournisseurservice.enums.FournisseurNature;
import com.lamkadam.fournisseurservice.enums.FournisseurType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class FournisseurDto {

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
