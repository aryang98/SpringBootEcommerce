package com.aryan.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.ecommerce.entity.CartItem;
import com.aryan.ecommerce.entity.User;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	List<CartItem> findCartItemByUser(User user);
}
