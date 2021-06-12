package com.vsh.VolgaStudHack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class Order {
    public Order(HashMap<String,Integer> dictionary){
        this.dictionary = dictionary;
    }

    @Id private String id;
    private HashMap<String,Integer> dictionary;

    public HashMap<String, Integer> getDictionary() {
        return dictionary;
    }

    public String getId() {
        return id;
    }

    public void setDictionary(HashMap<String, Integer> dictionary) {
        this.dictionary = dictionary;
    }
}
