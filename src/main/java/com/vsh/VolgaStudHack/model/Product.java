package com.vsh.VolgaStudHack.model;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import com.vsh.VolgaStudHack.ProductType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;


@Document
public class Product {

    public Product(ProductType type, String name, double price, Object image, String contentType){
        this.type = type;
        this.name = name;
        if (image instanceof Binary)
            this.image = (Binary) image;
        else
            this.image = new Binary(BsonBinarySubType.BINARY, Base64.getDecoder().decode(image.toString()));
        this.contentType = contentType;
        this.price = price;
    }


   /* public Product(ProductType type, String name, double price, String image, String contentType){
        this.type = type;
        this.name = name;
        this.image = new Binary(BsonBinarySubType.BINARY, Base64.getDecoder().decode(image));
        this.contentType = contentType;
        this.price = price;
    }*/


    @Id
    private String id;
    String name;
    double price;
    Binary image;
    ProductType type;
    String contentType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return String.format("Product [id=%s, type=%s, name=%s, price=%.2f, image=%s..., content-Type=%s]", id, type.name(), name, price, Base64.getEncoder().encodeToString(image.getData()).substring(0,6), contentType);
    }
}

