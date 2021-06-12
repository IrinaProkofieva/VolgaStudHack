package com.vsh.VolgaStudHack.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id){
        super("Cannot find a product with id = "+id);
    }
}
