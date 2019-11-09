package com.example.demo.rest.Entity;


import com.example.demo.rest.ConstValue;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = ConstValue.SCHEMA_NAME, name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categories_id;

    private String name;

    private String imageLink;

    private String description;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    public Categories(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Categories() {
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

    public Long getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(Long categories_id) {
        this.categories_id = categories_id;
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
