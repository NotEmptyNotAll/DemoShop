package com.example.demo.rest.web.DTO;

import com.example.demo.rest.Entity.Attribute;
import com.example.demo.rest.Entity.Categories;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    private Long productId;

    private String name;

    private Integer primaryPrice;

    private List<Attribute> attributes = new ArrayList<>();

    private Categories categories;

    //private MultipartFile fileData;


    private String nameCategories;

    private MultipartFile multipartFile;

    private String imageLink;

    public ProductDto() {
    }

    public ProductDto(String name, Integer primaryPrice, List<Attribute> attributes) {
        this.name = name;
        this.primaryPrice = primaryPrice;
        this.attributes = attributes;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
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
