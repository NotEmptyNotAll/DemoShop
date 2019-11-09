package com.example.demo.rest.Entity;

import com.example.demo.rest.ConstValue;

import javax.persistence.*;
import javax.websocket.Encoder;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(schema = ConstValue.SCHEMA_NAME,name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    private String name;

    private String fileType;


    private Integer primaryPrice;

    private String imageLink;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "product")
    private List<Attribute> attributes=new ArrayList<>();



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", nullable = false)
    private Categories categories;

    public Product() {
    }

    public Product(String name, Integer primaryPrice, List<Attribute> attributes, Categories categories) {
        this.name = name;
        this.primaryPrice = primaryPrice;
        this.attributes = attributes;
        this.categories = categories;

    }


    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrimaryPrice() {
        return primaryPrice;
    }

    public void setPrimaryPrice(Integer primaryPrice) {
        this.primaryPrice = primaryPrice;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
