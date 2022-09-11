package com.listener.jms.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;

@Service
public class Consumer {

    private Logger log = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void processCreateBookMessage(String content) throws JMSException {
        System.out.println(content);
    }

}
