package com.lamkadam.customerservice.service;

import com.lamkadam.customerservice.dtos.CustomerDTO;
import com.lamkadam.customerservice.entities.Customer;
import com.lamkadam.customerservice.exceptions.CustomerNotFoundException;
import com.lamkadam.customerservice.exceptions.EmailAlreadyUsedException;
import com.lamkadam.customerservice.mappers.CustomerMapper;
import com.lamkadam.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service @Transactional
@Slf4j @AllArgsConstructor
public class CustomerServiceImpl  implements CustomerService{

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;
    @Override
    public CustomerDTO save(CustomerDTO request) throws EmailAlreadyUsedException {
       if(customerRepository.checkIfEmailExist(request.getEmail()))
       throw  new EmailAlreadyUsedException(String.format("this email %s is already used",request.getEmail() ));
       Customer customer=customerMapper.from(request);
       Customer saveCustomer = customerRepository.save(customer);
       CustomerDTO customerDTO = customerMapper.from(saveCustomer);
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> listcustomers() {

   return customerRepository.findAll().stream().map(customerMapper ::from).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer ==null) throw  new CustomerNotFoundException(String.format("Castomer not found : %S" ,id));
        return customerMapper.from(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException, EmailAlreadyUsedException {

         Customer customer = customerRepository.findById(customerDTO.getId()).orElse(null);
         if(customer == null) throw  new CustomerNotFoundException(String.format("Castomer not found : %S" ,customerDTO.getId()));
        if (customerDTO.getFirstname() != null) customer.setFirstname(customerDTO.getFirstname());
        if(customerDTO.getLastname() != null) customer.setLastname(customerDTO.getLastname());
        if(customerDTO.getEmail() !=null) customer.setEmail(customerDTO.getEmail());
        if(customerDTO.getGenre() !=null) customer.setGenre(customerDTO.getGenre());

          Customer customerSaved = customerRepository.save(customer);
        return customerMapper.from(customerSaved);
    }

    @Override
    public void DeleteCustomer(Long id) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) throw new CustomerNotFoundException(String.format("Castomer not found : %S" ,id));
         customerRepository.delete(customer);
    }

    @Override
    public List<CustomerDTO> findCustomers(String kw) {

        List<Customer> customerList = customerRepository.searchCustomers(kw);

        return customerList.stream().map(customerMapper ::from).collect(Collectors.toList());
    }
}
