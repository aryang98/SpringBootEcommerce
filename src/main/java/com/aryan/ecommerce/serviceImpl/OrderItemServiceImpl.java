package com.aryan.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryan.ecommerce.entity.OrderItem;
import com.aryan.ecommerce.repository.OrderItemRepository;
import com.aryan.ecommerce.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public OrderItem addOrderItem(OrderItem orderItem) {

		return orderItemRepository.save(orderItem);
	}

	@Override
	public boolean deleteOrderItem(int orderItemId) {

		orderItemRepository.deleteById(orderItemId);
		return true;
	}

	@Override
	public List<OrderItem> getAllOrderItems() {

		return orderItemRepository.findAll();
	}

}
