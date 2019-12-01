package com.example.demo.rest.Repository;

import com.example.demo.rest.Entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface    CategoriesRepository extends JpaRepository<Categories, Long> {

    Categories findCategoriesByName(String name);


//    Categories findCategoriesByCategories_id (Long id);

}
