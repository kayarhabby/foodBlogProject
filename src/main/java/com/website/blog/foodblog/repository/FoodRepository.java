package com.website.blog.foodblog.repository;

import com.website.blog.foodblog.modele.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// avoir une interface qui étend JpaRepository avec un type générique et un type food
// JpaRepository est une interface qui prend deux types génériques, le premier est le type de l'entité et le deuxième est le type de l'identifiant de l'entité

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    List<Food> findByCategory(String category);
}
