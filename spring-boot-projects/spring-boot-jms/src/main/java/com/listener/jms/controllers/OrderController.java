package com.listener.jms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listener.jms.models.Order;
import com.listener.jms.repository.OrderRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository personRepository;  
    
    
    @GetMapping("/orders")
    public ResponseEntity<?> persons() {
        List<Order> orders = personRepository.findAll();
        return ResponseEntity.ok().body(orders);
    }

}

