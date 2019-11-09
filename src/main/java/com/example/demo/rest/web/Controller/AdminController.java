package com.example.demo.rest.web.Controller;

import com.example.demo.rest.Entity.AppUser;
import com.example.demo.rest.Service.UserService;
import com.example.demo.rest.web.WebUtils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String adminPage(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        List<AppUser> users = userService.findAllExceptAdmin();
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("users", users);
        return "adminPage";
    }

}
