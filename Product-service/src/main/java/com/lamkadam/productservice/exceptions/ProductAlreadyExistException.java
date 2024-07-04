package com.lamkadam.productservice.exceptions;

public class ProductAlreadyExistException extends Exception{

    public ProductAlreadyExistException (String message){
        super(message);
    }
}
