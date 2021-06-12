package com.vsh.VolgaStudHack;

import com.vsh.VolgaStudHack.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    public List<Order> findAll();
}
