package com.demo.spring.controllers;

import com.demo.spring.entity.Product;
import com.demo.spring.service.ProdService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Prod")
public class ProdRestController {

    private final ProdService prodService;

    public ProdRestController(ProdService prodService) {
        this.prodService = prodService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(prodService.getAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id) {
        return ResponseEntity.ok(prodService.getOne(id));
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> storeProduct(@RequestBody Product product) {
        return ResponseEntity.ok(prodService.save(product));
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return prodService.findByCategory(category);
    }

    @GetMapping("/cheaper/{price}")
    public List<Product> getProductsCheaperThan(@PathVariable Double price) {
        return prodService.findByPriceLessThan(price);
    }
}
