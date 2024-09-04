package com.lamkadam.productservice.repository;

import com.lamkadam.productservice.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

   Categorie findById(long id);
   Categorie findByName(String name);
}
