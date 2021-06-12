package com.vsh.VolgaStudHack.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsh.VolgaStudHack.OrderRepository;
import com.vsh.VolgaStudHack.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("id") String id){
        this.orderRepository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody String newOrder){
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = null;
        try {
            JsonNode node = objectMapper.readValue(newOrder, JsonNode.class);
            JsonNode dictionary = node.get("dictionary");
            order = new Order(objectMapper.convertValue(dictionary,  new TypeReference<HashMap<String, Integer>>(){}));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order replaceProduct(@RequestBody String newOrder, @PathVariable String id){
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = null;
        try {
            JsonNode node = objectMapper.readValue(newOrder, JsonNode.class);
            JsonNode dictionary = node.get("dictionary");
            order = new Order(objectMapper.convertValue(dictionary,  new TypeReference<HashMap<String, Integer>>(){}));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Order finalOrder = order;
        return orderRepository.findById(id).map(o -> {
            o.setDictionary(finalOrder.getDictionary());
            return orderRepository.save(o);
        }).orElseGet(() -> {
            finalOrder.setId(id);
            return orderRepository.save(finalOrder);
        });
    }
}

