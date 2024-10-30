package com.website.blog.foodblog.controller;

import com.website.blog.foodblog.modele.Food;
import com.website.blog.foodblog.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/foods")
    public void addFood(@RequestBody Food food) {
        foodService.addFood(food);
    }

    @GetMapping("/foods")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @GetMapping("/foods/{category}")
    public List<Food> getFoodByCategory(@PathVariable String category) {
        return foodService.getFoodByCategory(category);
    }

    @PutMapping("/foods/{foodId}")
    public void updateFood(@PathVariable int foodId) {
        foodService.updateFood(foodId);
    }

    @DeleteMapping("/foods/{foodId}")
    public void deleteFood(@PathVariable int foodId) {
        foodService.deleteFood(foodId);
    }
}
