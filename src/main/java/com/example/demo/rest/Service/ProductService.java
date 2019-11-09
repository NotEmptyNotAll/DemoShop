package com.example.demo.rest.Service;

import com.example.demo.rest.Repository.CategoriesRepository;
import com.example.demo.rest.Repository.ProductRepository;
import com.example.demo.rest.Entity.Categories;
import com.example.demo.rest.Entity.Product;
import com.example.demo.rest.web.DTO.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private AwsUploadService awsUploadService;

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(ProductDto productDto) {
        //Categories categories = categoriesRepository.findCategoriesByName(productDto.getNameCategories());
        Product product = new Product(productDto.getName(),
                productDto.getPrimaryPrice(),
                productDto.getAttributes(),
                productDto.getCategories());
        product.setImageLink(productDto.getImageLink());
        productRepository.save(product);
    }

    public void deleteProductById(Long productId) {
        List<Product> products = productRepository.findAll();
     //   awsUploadService.deleteFileFromS3Bucket(productRepository
        //        .findById(productId).get().getImageLink());
        productRepository.deleteById(productId);
    /*    for (Product product :
                products) {
            if (product.getProduct_id().equals(productId)) {
                productRepository.delete(product);
                break;
            }
        }*/
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

}
