package com.aryan.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.aryan.ecommerce.entity.CartItem;

public class CartDto {
	private String userEmail;

	private int totalAmount;
	private List<CartItem> cartItems = new ArrayList<>();

	public CartDto(String userEmail, int totalAmount, List<CartItem> cartItems) {
		super();
		this.userEmail = userEmail;
		this.totalAmount = totalAmount;
		this.cartItems = cartItems;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}