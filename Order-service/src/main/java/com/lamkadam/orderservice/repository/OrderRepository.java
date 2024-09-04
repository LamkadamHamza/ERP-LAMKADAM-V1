package com.lamkadam.orderservice.repository;

import com.lamkadam.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , String> {

    Order findOrderById(String id);
}
