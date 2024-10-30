package com.website.blog.foodblog.service;

import com.website.blog.foodblog.modele.Food;
import com.website.blog.foodblog.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    // inject foodRepository
    @Autowired
    private FoodRepository foodRepository;

    @Override
    // get food by category
    public List<Food> getFoodByCategory(String category) {
        return foodRepository.findByCategory(category);
    }


    @Override
    // get all food

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    // update food
    //retrieve the food by id and update the food with the given food id and update it with the new food
    public void updateFood(int foodId) {
        Food food = foodRepository.findById(foodId).get();
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(int foodId) {
        foodRepository.deleteById(foodId);
    }
}
