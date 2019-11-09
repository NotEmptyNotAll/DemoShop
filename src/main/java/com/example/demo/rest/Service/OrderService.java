package com.example.demo.rest.Service;

import com.example.demo.rest.Repository.OrderRepository;
import com.example.demo.rest.Entity.Order;
import com.example.demo.rest.web.DTO.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(OrderDto orderDto) {
        Order order = new Order(orderDto.getBirthDate(),
                orderDto.getOrderText(),
                orderDto.getDeadline(),
                orderDto.getAppUser());
        orderDto.getAppUser().getOrders().add(order);
        order.setImageLink(orderDto.getImageLink());
        orderRepository.save(order);
    }
}
