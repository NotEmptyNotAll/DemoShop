package com.example.demo.rest.Repository;

import com.example.demo.rest.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUserName(String userName);

    AppUser findByEmail(String email);

    AppUser findAppUserByUserId(Long id);


}
