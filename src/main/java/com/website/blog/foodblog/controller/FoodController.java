package com.website.blog.foodblog.controller;

import com.website.blog.foodblog.modele.Food;
import com.website.blog.foodblog.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // Cette méthode est mappée à la racine ("/")
    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }

    @PostMapping("api/foods")
    public ResponseEntity<Void> addFood(@RequestBody Food food) {
        foodService.addFood(food);
        return new ResponseEntity<>(HttpStatus.CREATED); // Retourne un statut 201 Created
    }

    @GetMapping("api/foods")
    public ResponseEntity<List<Food>> getAllFood() {
        List<Food> foods = foodService.getAllFood();
        return new ResponseEntity<>(foods, HttpStatus.OK); // Retourne la liste avec un statut 200 OK
    }

    @GetMapping("api/foods/category/{category}") // Changer le chemin pour spécifier que c'est une catégorie
    public ResponseEntity<List<Food>> getFoodByCategory(@PathVariable String category) {
        List<Food> foods = foodService.getFoodByCategory(category);
        return new ResponseEntity<>(foods, HttpStatus.OK); // Retourne la liste avec un statut 200 OK
    }

    @PutMapping("api/foods/{foodId}")
    public ResponseEntity<Void> updateFood(@PathVariable int foodId) {
        foodService.updateFood(foodId); // Assurez-vous que votre service prend également un objet Food
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un statut 204 No Content
    }

    @DeleteMapping("api/foods/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable int foodId) {
        foodService.deleteFood(foodId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un statut 204 No Content
    }
}
