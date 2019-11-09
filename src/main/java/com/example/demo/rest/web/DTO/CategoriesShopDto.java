package com.example.demo.rest.web.DTO;

import com.example.demo.rest.Entity.Categories;
import com.example.demo.rest.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoriesShopDto {

    private String name;

    private String imageLink;

    private List<List<Product>> products = new ArrayList<>();

    public CategoriesShopDto(String name, String imageLink, List<List<Product>> products) {
        this.name = name;
        this.imageLink = imageLink;
        this.products = products;
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

    public List<List<Product>> getProducts() {
        return products;
    }

    public void setProducts(List<List<Product>> products) {
        this.products = products;
    }
}
