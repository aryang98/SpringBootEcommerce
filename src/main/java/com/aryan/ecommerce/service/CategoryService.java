package com.aryan.ecommerce.service;

import java.util.List;

import com.aryan.ecommerce.entity.Category;


public interface CategoryService {
	Category addCategory(Category category);
	Category updateCategory(int categoryId, Category category);
	boolean deleteCategory(int categoryId);
	List<Category> getAllCategories();
	Category getCategoryById(int categoryId);
}
