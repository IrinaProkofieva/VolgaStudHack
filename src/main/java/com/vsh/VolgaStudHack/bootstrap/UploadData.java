package com.vsh.VolgaStudHack.bootstrap;


import com.vsh.VolgaStudHack.ProductRepository;
import com.vsh.VolgaStudHack.ProductType;
import com.vsh.VolgaStudHack.model.Product;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class UploadData implements CommandLineRunner {

    private ProductRepository repository;

    @Autowired
    public UploadData(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args){
        try {
            repository.save(new Product(ProductType.valueOf("SALAD"), "Салат Цезарь", 150.0, new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(Path.of("C:\\Users\\Irina\\Desktop\\Ира\\картинки\\хакатон\\salad_cesar.jpg"))), "image/jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
