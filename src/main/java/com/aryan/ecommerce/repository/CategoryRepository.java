package com.aryan.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.ecommerce.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
