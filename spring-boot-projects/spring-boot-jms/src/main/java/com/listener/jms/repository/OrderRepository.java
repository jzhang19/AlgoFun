package com.listener.jms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.listener.jms.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
