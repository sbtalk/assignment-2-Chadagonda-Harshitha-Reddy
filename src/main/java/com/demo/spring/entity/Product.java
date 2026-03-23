package com.demo.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long prodid;

    @Column(name = "name")
    private String prodname;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    private String category;

    public Product() {} // REQUIRED by JPA

    public Product(String prodname, Double price, String category) {
        this.prodname = prodname;
        this.price = price;
        this.category = category;
    }

    public Long getProdid() {
        return prodid;
    }

    public void setProdid(Long prodid) {
        this.prodid = prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}