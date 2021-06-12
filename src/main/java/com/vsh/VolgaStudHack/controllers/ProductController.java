package com.vsh.VolgaStudHack.controllers;

import com.vsh.VolgaStudHack.ProductRepository;
import com.vsh.VolgaStudHack.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(
                this.productRepository.findAll()
        );
    }

    @GetMapping("/warmmeal")
    public ResponseEntity<List<Product>> getWarmMeals(){
        return ResponseEntity.ok(this.productRepository.findByType("WARMMEAL"));
    }

    @GetMapping("/salad")
    public ResponseEntity<List<Product>> getSalads(){
        return ResponseEntity.ok(this.productRepository.findByType("SALAD"));
    }

    @GetMapping("/baking")
    public ResponseEntity<List<Product>> getBaking(){
        return ResponseEntity.ok(this.productRepository.findByType("BAKING"));
    }

    @GetMapping("/groceries")
    public ResponseEntity<List<Product>> getGroceries(){
        return ResponseEntity.ok(this.productRepository.findByType("GROCERIES"));
    }

    @GetMapping("/drinks")
    public ResponseEntity<List<Product>> getDrinks(){
        return ResponseEntity.ok(this.productRepository.findByType("DRINK"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") String id){
        this.productRepository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product newProduct){
        return this.productRepository.save(newProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id") String id){
        return ResponseEntity.ok(this.productRepository.findById(id));
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable String id){
        return productRepository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setContentType(newProduct.getContentType());
            product.setImage(newProduct.getImage());
            product.setPrice(newProduct.getPrice());
            product.setType(newProduct.getType());
            return productRepository.save(product);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        });
    }



}
