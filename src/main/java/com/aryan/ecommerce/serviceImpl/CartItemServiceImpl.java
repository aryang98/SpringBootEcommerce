package com.aryan.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryan.ecommerce.entity.CartItem;
import com.aryan.ecommerce.entity.User;
import com.aryan.ecommerce.repository.CartItemRepository;
import com.aryan.ecommerce.service.CartItemService;


@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;
	
	@Override
	public CartItem addCartItem(CartItem cartItem) {

		return cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem updateCartItem(int cartItemId, CartItem cartItem) {
		CartItem cartItem2=cartItemRepository.findById(cartItemId).get();
		cartItem2.setQuantity(cartItem.getQuantity());
		cartItem2.setPaymentStatus(cartItem.getPaymentStatus());
		return cartItemRepository.save(cartItem2);
	}

	@Override
	public boolean deleteCartItem(int cartItemId) {
		cartItemRepository.deleteById(cartItemId);
		return true;
	}

	@Override
	public List<CartItem> getAllCartItems() {
		
		return cartItemRepository.findAll();
	}

	@Override
	public CartItem getCartItemById(int cartItemId) {

		return cartItemRepository.findById(cartItemId).get();
	}

	@Override
	public List<CartItem> getCartItemByUser(User user) {

		return cartItemRepository.findCartItemByUser(user);
	}

}
