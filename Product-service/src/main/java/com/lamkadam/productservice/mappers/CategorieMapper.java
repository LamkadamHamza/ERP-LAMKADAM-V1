package com.lamkadam.productservice.mappers;

import com.lamkadam.productservice.dtos.CategorieDTO;
import com.lamkadam.productservice.entities.Categorie;
import jdk.javadoc.doclet.DocletEnvironment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class CategorieMapper {

    ModelMapper modelMapper =new ModelMapper();



    public CategorieDTO from (Categorie categorie){
        return modelMapper.map(categorie, CategorieDTO.class);
    }


    public  Categorie from (CategorieDTO categorieDTO){
        return  modelMapper.map(categorieDTO , Categorie.class);
    }
}
