package com.example.demo.rest.Service;


import com.example.demo.rest.DAO.AppRoleDAO;
import com.example.demo.rest.Repository.UserRepository;
import com.example.demo.rest.Entity.AppUser;
import com.example.demo.rest.web.DTO.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AppRoleDAO appRoleDAO;

    public List<AppUser> findAllExceptAdmin() {
        List<AppUser> users = userRepository.findAll();
        AppUser admin = userRepository.findAppUserByUserId((long) 1);
        users.remove(admin);
        return users;
    }

    public AppUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(UserRegistrationDto userRegistrationDto) {
        AppUser appUser = new AppUser(userRegistrationDto.getName(),
                passwordEncoder.encode(userRegistrationDto.getPassword()),
                userRegistrationDto.getEmail());
        userRepository.save(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findAppUserByUserName(userName);
        if (appUser == null) {
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);
        return userDetails;
    }

}