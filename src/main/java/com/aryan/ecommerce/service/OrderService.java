package com.aryan.ecommerce.service;

import java.util.List;

import com.aryan.ecommerce.entity.Order;
import com.aryan.ecommerce.entity.User;


public interface OrderService {
	Order addOrder(Order order);
	Order updateOrder(int orderId, Order order);
	Order assignDelivery(int orderId, Order order);
	Order updateDelivery(int orderId, Order order);
	boolean deleteOrder(int orderId);
	List<Order> getAllOrders();
	Order getOrderById(int orderId);
	List<Order> getOrdersByUser(User user);
	List<Order> getOrdersDeliveryPerson(User user);
}
