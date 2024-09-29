package com.aryan.ecommerce.service;

import java.util.List;

import com.aryan.ecommerce.entity.OrderItem;



public interface OrderItemService {
	OrderItem addOrderItem(OrderItem orderItem);
	boolean deleteOrderItem(int orderItemId);
	List<OrderItem> getAllOrderItems();
}
