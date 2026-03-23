package com.demo.spring.service;



import com.demo.spring.entity.Product;

import com.demo.spring.repositories.ProdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdService {
    private ProdRepository prodRepository;

    public ProdService(ProdRepository prodRepository) {
        this.prodRepository = prodRepository;
    }
    public List<Product> getAll(){
        return this.prodRepository.findAll();
    }
    public Product getOne(Long id){
        return this.prodRepository.findById(id).get();
    }
    public Product save(Product p){
        return prodRepository.save(p);
    }
    public List<Product> findByCategory(String category) {
        return prodRepository.findByCategory(category);
    }

    // Find products cheaper than a given price
    public List<Product> findByPriceLessThan(Double price) {
        return prodRepository.findByPriceLessThan(price);
    }
}
