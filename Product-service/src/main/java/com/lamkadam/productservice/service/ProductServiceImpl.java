package com.lamkadam.productservice.service;

import com.lamkadam.productservice.clients.FournisseurRestClient;
import com.lamkadam.productservice.dtos.ProductDTO;
import com.lamkadam.productservice.entities.Categorie;
import com.lamkadam.productservice.entities.Product;
import com.lamkadam.productservice.exceptions.ProductAlreadyExistException;
import com.lamkadam.productservice.exceptions.ProductNotFoundException;
import com.lamkadam.productservice.mappers.ProductMapper;
import com.lamkadam.productservice.repository.CategorieRepository;
import com.lamkadam.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
@Slf4j @AllArgsConstructor
public class ProductServiceImpl  implements ProductService {

    private ProductRepository productRepository;
    private CategorieRepository categorieRepository;
    private FournisseurRestClient fournisseurRestClient;
    private ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductDTO request) throws ProductAlreadyExistException {
        if(productRepository.checkIfProductIdExist(request.getId()))
            throw new  ProductAlreadyExistException(String.format(" product Already Exist " , request.getId()));
        Product product = productMapper.from(request);
        Product saveProduct =productRepository.save(product);
        ProductDTO productDTO = productMapper.from(saveProduct);
        return productDTO;
    }

    @Override
    public List<ProductDTO> GetListProduct() {
        List<ProductDTO> productDTOList =productRepository.findAll().stream().map(productMapper ::from).collect(Collectors.toList());
            productDTOList.forEach(f->{
                f.setFournisseur(fournisseurRestClient.findFournisseurById((long) f.getFOURNCODEINT()));
                
            });
        return productDTOList;
    }

    @Override
    public ProductDTO GetProductById(String id) throws ProductNotFoundException {
        Product product =productRepository.findById(id).orElse(null);
        if(product ==null) throw  new ProductNotFoundException(String.format("product not exist : %S" ,id));
        return productMapper.from(product);
    }

    @Override
    public ProductDTO UpdateProduct(ProductDTO productDTO) throws ProductNotFoundException, ProductAlreadyExistException {
        if(productRepository.checkIfProductIdExist(productDTO.getId()))
            throw new  ProductAlreadyExistException(String.format(" product Already Exist " , productDTO.getId()));
        Product product =productRepository.findById(productDTO.getId()).orElse(null);
        if(product == null) throw  new ProductNotFoundException(String.format("product not exist : %S" ,productDTO.getId()));
        if(productDTO.getName() != null) product.setName(productDTO.getName());
        //if(productDTO.getPrice() != null) product.setPrice(productDTO.getPrice());
          Product productupadate =  productRepository.save(product);
        return productMapper.from(productupadate);
    }

    @Override
    public void deleteProduct(String id) throws ProductNotFoundException {
        Product product =productRepository.findById(id).orElse(null);
        if(product == null) throw  new ProductNotFoundException(String.format("product not exist : %S" ,id));
         productRepository.delete(product);

    }

    @Override
    public List<ProductDTO> findProduct(String kw) {
        return null;
    }

    @Override
    public ProductDTO assignCategoryToProduct(String productId, Long categoryId) {
        Product product = productRepository.findById(productId).orElse(null);
        Categorie categorie = categorieRepository.findById(categoryId).orElse(null);
        product.setCategorie(categorie); // assuming you have a setCategorie method
       Product productsaved = productRepository.save(product);


        return productMapper.from(productsaved);
    }
}
