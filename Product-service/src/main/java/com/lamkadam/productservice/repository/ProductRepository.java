package com.lamkadam.productservice.repository;

import com.lamkadam.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product , String> {

    @Query("select case when count(p)>0 then true else false END from Product  p where p.id =?1")
    Boolean checkIfProductIdExist(String id);
}
