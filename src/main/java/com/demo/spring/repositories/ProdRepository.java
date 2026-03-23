package com.demo.spring.repositories;


import com.demo.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(String category);
    List<Product> findByPriceLessThan(Double price);
}

