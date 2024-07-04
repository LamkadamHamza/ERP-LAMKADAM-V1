package com.lamkadam.customerservice.mappers;


import com.lamkadam.customerservice.dtos.CustomerDTO;
import com.lamkadam.customerservice.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    ModelMapper modelMapper = new ModelMapper();

    public CustomerDTO from(Customer customer){
        return modelMapper.map(customer,CustomerDTO.class);
    }

    public  Customer from (CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,Customer.class);
    }


}
