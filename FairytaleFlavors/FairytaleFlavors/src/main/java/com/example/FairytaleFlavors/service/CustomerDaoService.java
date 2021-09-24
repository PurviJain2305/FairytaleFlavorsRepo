package com.example.FairytaleFlavors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FairytaleFlavors.bean.Recipe;
import com.example.FairytaleFlavors.repository.RecipeRepository;

@Service
public class CustomerDaoService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	public CustomerDaoService() {
	}

	public void insert(Recipe recipe) {
		recipeRepository.save(recipe);
	}

	public Optional<Recipe> getRecipeById(Long id) {
		return recipeRepository.findById(id);
	}

	public Optional<Recipe> getRecipeByName(String recipeName) {
        Optional<Recipe> recipe = recipeRepository.findByRecipeName(recipeName);
        return recipe; 
    }
	
	public List<Optional<Recipe>> getRecipeByType(Boolean isVegetarian) {
		List<Optional<Recipe>> recipe = (List<Optional<Recipe>>) recipeRepository.findByIsVegetarian(isVegetarian);
        return recipe; 
    }
	
	public List<Optional<Recipe>> getRecipeByServingSize(Integer servingSize) {
		List<Optional<Recipe>> recipe = (List<Optional<Recipe>>) recipeRepository.findByServingSize(servingSize);
        return recipe; 
    }

	public List<Recipe> getRecipeList() {
		List<Recipe> recipe = recipeRepository.findAll();
        return recipe; 
    }
	
	public void deleteRecipeById(Long id) {
		recipeRepository.deleteById(id);
	}
	
}
