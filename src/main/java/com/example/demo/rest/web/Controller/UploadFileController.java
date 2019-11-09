package com.example.demo.rest.web.Controller;

import com.example.demo.rest.Service.ProductService;
import com.example.demo.rest.web.DTO.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileController {

    @Autowired
    private ProductService productService;

    public static ProductDto productDto;

    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
        try {
            // save file to PostgreSQL
            productDto.setMultipartFile(file);
            productService.save(productDto);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
        } catch (Exception e) {
            return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
        }
    }
}
