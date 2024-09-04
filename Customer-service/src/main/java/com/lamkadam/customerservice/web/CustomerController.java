package com.lamkadam.customerservice.web;


import com.lamkadam.customerservice.dtos.CustomerDTO;
import com.lamkadam.customerservice.exceptions.CustomerNotFoundException;
import com.lamkadam.customerservice.exceptions.EmailAlreadyUsedException;
import com.lamkadam.customerservice.service.CustomerService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {


    private CustomerService customerService ;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> listCustomer(){
       return customerService.listcustomers();

    }


    @PostMapping("/customers")
    public ResponseEntity<?> AddCustomer(@RequestBody CustomerDTO request) throws EmailAlreadyUsedException {
        try {
            CustomerDTO  customerDTO =  customerService.save(request);
            return  ResponseEntity.ok(customerDTO);
        }catch (EmailAlreadyUsedException e){
            return  ResponseEntity.internalServerError().body( new ErrorMessage(e.getMessage()));
        }

    }

    @GetMapping("/customers/{id}")
    public  ResponseEntity<?> GetCustomerById(@PathVariable Long id ) throws CustomerNotFoundException {
       try {
           CustomerDTO customerbyId = customerService.getCustomerById(id);
           return ResponseEntity.ok(customerbyId);
       } catch (CustomerNotFoundException e){
           return  ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
       }

    }


    @DeleteMapping("/customers/{id}")
    public  ResponseEntity<?>  DeleteCustomer(@PathVariable Long id){
        try {
             customerService.DeleteCustomer(id);
             return  ResponseEntity.noContent().build();
        } catch (CustomerNotFoundException e){
              return   ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }

    @GetMapping("/customers/search")
    public  List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword){

     return   customerService.findCustomers("%"+keyword+"%");

    }



    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody  CustomerDTO requst, @PathVariable Long id){
        try {
            CustomerDTO customerUpadte = customerService.updateCustomer(requst);

            return  ResponseEntity.ok(customerUpadte);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body( new ErrorMessage(e.getMessage()));
        }
    }


    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

}
