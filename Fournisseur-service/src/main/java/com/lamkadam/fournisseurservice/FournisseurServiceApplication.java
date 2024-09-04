package com.lamkadam.fournisseurservice;

import com.lamkadam.fournisseurservice.entities.Fournisseur;
import com.lamkadam.fournisseurservice.enums.FournisseurEtat;
import com.lamkadam.fournisseurservice.enums.FournisseurNature;
import com.lamkadam.fournisseurservice.enums.FournisseurType;
import com.lamkadam.fournisseurservice.repository.FournisseurRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

public class FournisseurServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournisseurServiceApplication.class, args);
	}

  @Bean
  CommandLineRunner commandLineRunner(FournisseurRepository fournisseurRepository) {
      return args -> {
         /*for (int i=0; i < 10 ;i++){

           Fournisseur fournisseur = Fournisseur.builder()
             .FOURNCODEEXT((int) (Math.random()*12))
             .FOURLIBL("FOUR")
             .FOURETAT(FournisseurEtat.ACTIF)
             .FOURTYPE(FournisseurType.CENTRAL)
             .FOURNATU(FournisseurNature.TRANSPORT)
             .FOURTAXE(1)
             .FOURTVA(1)
             .FOURCRE(new Date())
             .FOURMAJ(new Date())
             .FOURUTIL("hamza")
             .build();
          fournisseurRepository.save(fournisseur);
         }*/




      Fournisseur fournisseur1 = Fournisseur.builder()
              .FOURNCODEEXT((int) (Math.random() * 12))
              .FOURLIBL("Procter")
              .FOURETAT(FournisseurEtat.ACTIF)
              .FOURTYPE(FournisseurType.CENTRAL)
              .FOURNATU(FournisseurNature.TRANSPORT)
              .FOURTAXE(1)
              .FOURTVA(1)
              .FOURCRE(new Date())
              .FOURMAJ(new Date())
              .FOURUTIL("hamza")
              .build();

      Fournisseur fournisseur2 = Fournisseur.builder()
              .FOURNCODEEXT((int) (Math.random() * 12))
              .FOURLIBL("Unilever")
              .FOURETAT(FournisseurEtat.ACTIF)
              .FOURTYPE(FournisseurType.EXTERNE)
              .FOURNATU(FournisseurNature.MARCHANDISE)
              .FOURTAXE(2)
              .FOURTVA(1)
              .FOURCRE(new Date())
              .FOURMAJ(new Date())
              .FOURUTIL("hamza")
              .build();

      Fournisseur fournisseur3 = Fournisseur.builder()
              .FOURNCODEEXT((int) (Math.random() * 12))
              .FOURLIBL("Nestle")
              .FOURETAT(FournisseurEtat.ACTIF)
              .FOURTYPE(FournisseurType.CENTRAL)
              .FOURNATU(FournisseurNature.MARCHANDISE)
              .FOURTAXE(1)
              .FOURTVA(1)
              .FOURCRE(new Date())
              .FOURMAJ(new Date())
              .FOURUTIL("hamza")
              .build();

      Fournisseur fournisseur4 = Fournisseur.builder()
              .FOURNCODEEXT((int) (Math.random() * 12))
              .FOURLIBL("Kraft Heinz")
              .FOURETAT(FournisseurEtat.ACTIF)
              .FOURTYPE(FournisseurType.CENTRAL)
              .FOURNATU(FournisseurNature.TRANSPORT)
              .FOURTAXE(1)
              .FOURTVA(1)
              .FOURCRE(new Date())
              .FOURMAJ(new Date())
              .FOURUTIL("hamza")
              .build();

      Fournisseur fournisseur5 = Fournisseur.builder()
              .FOURNCODEEXT((int) (Math.random() * 12))
              .FOURLIBL("PepsiCo")
              .FOURETAT(FournisseurEtat.ACTIF)
              .FOURTYPE(FournisseurType.CENTRAL)
              .FOURNATU(FournisseurNature.MARCHANDISE)
              .FOURTAXE(2)
              .FOURTVA(1)
              .FOURCRE(new Date())
              .FOURMAJ(new Date())
              .FOURUTIL("hamza")
              .build();

      fournisseurRepository.save(fournisseur1);
      fournisseurRepository.save(fournisseur2);
      fournisseurRepository.save(fournisseur3);
      fournisseurRepository.save(fournisseur4);
      fournisseurRepository.save(fournisseur5);
  };
  }

}
