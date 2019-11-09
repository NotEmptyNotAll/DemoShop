package com.example.demo.rest.DAO;

import java.util.ArrayList;
import java.util.List;


import com.example.demo.rest.Entity.AppUser;
import com.example.demo.rest.Repository.RoleRepository;
import com.example.demo.rest.Repository.UserRepository;
import com.example.demo.rest.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppRoleDAO {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    public List<String> getRoleNames(AppUser appUser) {
        List<String> list = new ArrayList<>();
        if (appUser.getUserId() == 1) {
            list.add("ROLE_ADMIN");
            list.add("ROLE_USER");
        } else {
            list.add("ROLE_USER");
        }
        return list;
    }

}