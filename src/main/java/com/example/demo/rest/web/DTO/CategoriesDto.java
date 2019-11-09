package com.example.demo.rest.web.DTO;

import com.example.demo.rest.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoriesDto {

    private String name;

    private String imageLink;

    private String description;

    private List<Product> products = new ArrayList<>();

    public CategoriesDto() {
    }

    public CategoriesDto(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
