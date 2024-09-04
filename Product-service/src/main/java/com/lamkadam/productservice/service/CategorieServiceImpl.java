package com.lamkadam.productservice.service;

import com.lamkadam.productservice.dtos.CategorieDTO;
import com.lamkadam.productservice.dtos.ProductDTO;
import com.lamkadam.productservice.entities.Categorie;
import com.lamkadam.productservice.exceptions.CategorieAlreadyExistException;
import com.lamkadam.productservice.exceptions.CategorieNotFoundException;
import com.lamkadam.productservice.mappers.CategorieMapper;
import com.lamkadam.productservice.repository.CategorieRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService{

    private CategorieRepository categorieRepository;

    private CategorieMapper categorieMapper;




    @Override
    public List<CategorieDTO> getAllCategorie() {
        List<CategorieDTO> categorieDTOS = categorieRepository.findAll().stream().map(categorieMapper ::from).collect(Collectors.toList());

        return  categorieDTOS;
    }

    @Override
    public CategorieDTO SaveCategorie(CategorieDTO categorieDTO) throws CategorieAlreadyExistException {
        return null;
    }

    @Override
    public CategorieDTO updateCategorie(CategorieDTO categorieDTO) throws CategorieAlreadyExistException, CategorieNotFoundException {
        return null;
    }

    @Override
    public void deleteCategorie(Long id) {

    }
}
