package com.listener.jms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listener.jms.models.Order;
import com.listener.jms.repository.OrderRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private OrderRepository orderRepository;  
    
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody String message) {
        jmsTemplate.convertAndSend(message);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> orders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok().body(orders);
    }

}

