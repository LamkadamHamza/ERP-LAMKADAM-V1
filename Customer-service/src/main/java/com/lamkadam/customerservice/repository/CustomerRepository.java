package com.lamkadam.customerservice.repository;

import com.lamkadam.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query("select case when count(c)>0 then true else false END from Customer  c where c.Email =?1")
    Boolean checkIfEmailExist(String email);

    @Query("select c from Customer  c where (c.firstname like:kw )"+
    "or (c.lastname like :kw)")
    List<Customer> searchCustomers(String kw);


}
