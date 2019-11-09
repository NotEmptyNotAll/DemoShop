package com.example.demo.rest.Repository;

import com.example.demo.rest.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderById(Long id);
}
