package com.vsh.VolgaStudHack.bootstrap;


import com.vsh.VolgaStudHack.OrderRepository;
import com.vsh.VolgaStudHack.ProductRepository;
import com.vsh.VolgaStudHack.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class UploadData implements CommandLineRunner {

    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    public UploadData(ProductRepository productRepository, OrderRepository orderRepository){
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args){

        /*
        try {
            //repository.save(new Product(ProductType.valueOf("SALAD"), "Салат Цезарь", 150.0, new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(Path.of("C:\\Users\\Irina\\Desktop\\Ира\\картинки\\хакатон\\salad_cesar.jpg"))), "image/jpeg"));

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*orderRepository.save(new Order(new HashMap<String, Integer>() {{
            put("60c47862aebf4d303f396345", 2);
            put("60c48c263d67133a531af390", 1);
        }}));*/
    }
}
