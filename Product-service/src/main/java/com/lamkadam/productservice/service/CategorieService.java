package com.lamkadam.productservice.service;

import com.lamkadam.productservice.dtos.CategorieDTO;
import com.lamkadam.productservice.exceptions.CategorieAlreadyExistException;
import com.lamkadam.productservice.exceptions.CategorieNotFoundException;

import java.util.List;

public interface CategorieService {


    List<CategorieDTO> getAllCategorie() ;

    CategorieDTO SaveCategorie(CategorieDTO categorieDTO) throws CategorieAlreadyExistException;

    CategorieDTO updateCategorie (CategorieDTO categorieDTO) throws  CategorieAlreadyExistException, CategorieNotFoundException;


    void  deleteCategorie(Long id);
}
