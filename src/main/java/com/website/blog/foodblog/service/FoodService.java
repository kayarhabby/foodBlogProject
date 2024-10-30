package com.website.blog.foodblog.service;

import com.website.blog.foodblog.modele.Food;

import java.util.List;

public interface FoodService {

    // get food by category
    List<Food> getFoodByCategory(String category);

    // get all food
    List<Food> getAllFood();

    // add food
    Food addFood(Food food);

    // update food
    void updateFood(int foodId);

    // delete food
    void deleteFood(int foodId);
}
