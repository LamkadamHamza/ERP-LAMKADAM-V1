package com.lamkadam.customerservice.service;


import com.lamkadam.customerservice.dtos.CustomerDTO;
import com.lamkadam.customerservice.exceptions.CustomerNotFoundException;
import com.lamkadam.customerservice.exceptions.EmailAlreadyUsedException;

import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerDTO request ) throws EmailAlreadyUsedException ;
    List<CustomerDTO> listcustomers();

    CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException;

    CustomerDTO updateCustomer (CustomerDTO customerDTO) throws CustomerNotFoundException , EmailAlreadyUsedException;

    void DeleteCustomer (Long id) throws CustomerNotFoundException;

    List<CustomerDTO> findCustomers (String kw);
}
