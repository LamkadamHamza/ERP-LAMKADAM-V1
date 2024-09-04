package com.lamkadam.productservice.web;


import com.lamkadam.productservice.dtos.CategorieDTO;
import com.lamkadam.productservice.entities.Categorie;
import com.lamkadam.productservice.mappers.CategorieMapper;
import com.lamkadam.productservice.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieController {


    private CategorieService categorieService;
    private CategorieMapper categorieMapper;


    @GetMapping("/categories")
    public List<Categorie> getAllCategories(){
        List<CategorieDTO> categorieDTOS = categorieService.getAllCategorie();

        List<Categorie> categorieList = categorieDTOS.stream().map(categorieMapper ::from).collect(Collectors.toList());
        return  categorieList;
    }

}
