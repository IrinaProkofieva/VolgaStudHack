package com.vsh.VolgaStudHack;

import com.vsh.VolgaStudHack.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findAll();
    public List<Product> findByType(String type);
}
