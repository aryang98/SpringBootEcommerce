package com.aryan.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.ecommerce.entity.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
