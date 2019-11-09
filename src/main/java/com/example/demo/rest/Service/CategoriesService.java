package com.example.demo.rest.Service;

import com.example.demo.rest.Repository.CategoriesRepository;
import com.example.demo.rest.Entity.Categories;
import com.example.demo.rest.web.DTO.CategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;


    public Categories findByName(String name) {
        return categoriesRepository.findCategoriesByName(name);
    }

    public void deleteById(Long categId) {

        categoriesRepository.deleteById(categId);
    }

    public void save(CategoriesDto categoriesDto) {

        Categories categories = new Categories(categoriesDto.getName(),
                categoriesDto.getProducts());
        categories.setDescription(categoriesDto.getDescription());
        categories.setImageLink(categoriesDto.getImageLink());
        categoriesRepository.save(categories);
    }

    public List<Categories> findAllCategories() {
        return categoriesRepository.findAll();
    }
}
