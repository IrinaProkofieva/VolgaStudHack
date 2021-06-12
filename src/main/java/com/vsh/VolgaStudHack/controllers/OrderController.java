package com.vsh.VolgaStudHack.controllers;

import com.vsh.VolgaStudHack.OrderRepository;
import com.vsh.VolgaStudHack.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok(
                this.orderRepository.findAll()
        );
    }

}

