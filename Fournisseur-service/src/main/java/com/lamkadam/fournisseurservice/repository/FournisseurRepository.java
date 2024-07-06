package com.lamkadam.fournisseurservice.repository;

import com.lamkadam.fournisseurservice.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
}