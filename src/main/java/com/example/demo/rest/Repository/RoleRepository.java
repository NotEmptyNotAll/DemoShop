package com.example.demo.rest.Repository;

import com.example.demo.rest.Entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRoleId(Long id);

}
