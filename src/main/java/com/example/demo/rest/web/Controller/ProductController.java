package com.example.demo.rest.web.Controller;

import com.example.demo.rest.Entity.Categories;
import com.example.demo.rest.Service.CategoriesService;
import com.example.demo.rest.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController  {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public  String showCategries(Model model, Principal principal){
        List<Categories> listCategories =categoriesService.findAllCategories();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("listProduct", productService.findAll());
        return "product";


    }
}
