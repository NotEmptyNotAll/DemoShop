package com.example.demo.rest.web.Controller;

import com.example.demo.rest.Repository.UserRepository;
import com.example.demo.rest.Entity.Categories;
import com.example.demo.rest.Entity.Order;
import com.example.demo.rest.Service.AwsUploadService;
import com.example.demo.rest.Service.CategoriesService;
import com.example.demo.rest.Service.GoogleDriveService;
import com.example.demo.rest.Service.OrderService;
import com.example.demo.rest.web.DTO.OrderDto;
import com.example.demo.rest.web.WebUtils.WebUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/userInfo")
public class UserController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoriesService categoriesService;



    @Autowired
    private AwsUploadService awsUploadService;

    @ModelAttribute("orderDto")
    public OrderDto orderDto() {
        return new OrderDto();
    }


    @GetMapping
    public String userInfo(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        // After user login successfully.
        Set<Order> orders = userRepository.findAppUserByUserName(loginedUser.getUsername()).getOrders();
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy/MM/dd");
        List<Categories> categories = categoriesService.findAllCategories();
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("orders", orders);
        model.addAttribute("date", formatForDateNow.format(date));
        model.addAttribute("categories", categories);
        return "userInfo";
    }

    @PostMapping
    public String createOrder(@ModelAttribute("orderDto") @Valid OrderDto orderDto,
                              @RequestParam("file") MultipartFile file,
                              Principal principal) throws IOException {
        orderDto.setImageLink(awsUploadService.uploadFile(file));
        System.out.println(orderDto.getImageLink());
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy/MM/dd");
        orderDto.setBirthDate(formatForDateNow.format(date));
        orderDto.setAppUser(userRepository.findAppUserByUserName(loginedUser.getUsername()));

        orderService.save(orderDto);
        return "redirect:/userInfo";
    }

}
