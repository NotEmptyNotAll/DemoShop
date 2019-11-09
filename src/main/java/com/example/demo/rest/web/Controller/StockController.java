package com.example.demo.rest.web.Controller;

import com.example.demo.rest.Entity.Categories;
import com.example.demo.rest.Service.*;
import com.example.demo.rest.web.DTO.AttributeDto;
import com.example.demo.rest.web.DTO.CategoriesDto;
import com.example.demo.rest.web.DTO.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class StockController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AwsUploadService awsUploadService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private AttributeService attributeService;


    @ModelAttribute("categoriesDto")
    public CategoriesDto categoriesDto() {
        return new CategoriesDto();
    }

    @ModelAttribute("productDto")
    public ProductDto productDto() {
        return new ProductDto();
    }

    @ModelAttribute("attributeDto")
    public AttributeDto attributeDto() {
        return new AttributeDto();
    }

    @GetMapping
    public String stockPage(Model model, Principal principal) {
        // User loginUser= (User) ((Authentication)principal).getPrincipal();
        List<Categories> categories = categoriesService.findAllCategories();
        model.addAttribute("categories", categories);
        return "stock";
    }

    @PostMapping("/addCategories")
    public String newCategories(@ModelAttribute("categoriesDto") CategoriesDto categoriesDto,
                                @RequestParam("file") MultipartFile file,
                                Principal principal) throws IOException {
        categoriesDto.setImageLink(awsUploadService.uploadFile(file));
        categoriesService.save(categoriesDto);
        return "redirect:/stock";
    }


    @PostMapping("/addProduct")
    public String newProduct(@ModelAttribute("productDto") ProductDto productDto,
                             @RequestParam("file") MultipartFile file,
                             Principal principal) throws IOException {
        productDto.setImageLink(awsUploadService.uploadFile(file));
        productDto.setCategories(categoriesService.findByName(productDto.getNameCategories()));
        productService.save(productDto);
        return "redirect:/stock";
    }


    @PostMapping("/addAttribute")
    public String newAttribute(@RequestParam(value = "action", required = true) Long action,
                               @ModelAttribute("AttributeDto") @Valid AttributeDto attributeDto,
                               Principal principal) {
        System.out.println(action);
        attributeDto.setProduct(productService.findById(action));
        attributeService.save(attributeDto);
        return "redirect:/stock";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProductById(
            @PathVariable("productId") Long productId, Model model) {
        productService.deleteProductById(productId);
        return "redirect:/stock";
    }

    @GetMapping("/deleteAttribute/{attributeId}")
    public String deleteAttribute(
            @PathVariable("attributeId") Long attributeId, Model model) {
        attributeService.deleteAttribute(attributeId);
        return "redirect:/stock";
    }

    @GetMapping("/deleteCategories/{categid}")
    public String deleteCategories(
            @PathVariable("categid") Long categid, Model model) {
        categoriesService.deleteById(categid);
        return "redirect:/stock";
    }

}
