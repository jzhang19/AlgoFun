package com.listener.jms.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.listener.jms.models.Order;
import com.listener.jms.repository.OrderRepository;

import jakarta.jms.JMSException;

@Service
public class OrderListenerService {

    private Logger log = LoggerFactory.getLogger(OrderListenerService.class);

    @Autowired
    private OrderRepository orderRepository;

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void processCreateBookMessage(Order order) throws JMSException {
        orderRepository.save(order);
        log.info("Order Received: logging: {} {} ordered {}", new Object[] { order.getFirstName(), order.getLastName(), order.getItem() });
    }

}
