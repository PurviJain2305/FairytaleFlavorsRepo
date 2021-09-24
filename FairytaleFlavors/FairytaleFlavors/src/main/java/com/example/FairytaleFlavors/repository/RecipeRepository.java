package com.example.FairytaleFlavors.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FairytaleFlavors.bean.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
		public Optional<Recipe> findByRecipeName(String recipeName);
		
		public List<Optional<Recipe>> findByIsVegetarian(Boolean isVegetarian);
		
		public List<Optional<Recipe>> findByServingSize(Integer servingSize);
		
}
