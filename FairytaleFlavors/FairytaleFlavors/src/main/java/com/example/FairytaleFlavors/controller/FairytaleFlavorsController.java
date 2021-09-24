package com.example.FairytaleFlavors.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FairytaleFlavors.bean.Recipe;
import com.example.FairytaleFlavors.exception.RecipeIdNotFoundException;
import com.example.FairytaleFlavors.exception.RecipeNotFoundException;
import com.example.FairytaleFlavors.service.CustomerDaoService;

@RestController
public class FairytaleFlavorsController {

	@Autowired
	private CustomerDaoService customerDaoService;

	@PostMapping("/createRecipe")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy, HH:mm");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		if (recipe.getId() == null) {
			recipe.setCreateDate(sdf.format(date));
		}
		recipe.setUpdatedDate(sdf.format(date));
		customerDaoService.insert(recipe);
		return new ResponseEntity<>(recipe, HttpStatus.CREATED);
	}

	@GetMapping("/getRecipeById")
	public ResponseEntity<Object> getRecipeById(@RequestParam(value = "id") Long id) {
		Optional<Recipe> recipe = customerDaoService.getRecipeById(id);
		if (recipe.isEmpty()) {
			throw new RecipeNotFoundException("Recipe Not Found with Id: "+id);
		}
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@GetMapping("/getRecipeByName")
	public ResponseEntity<Object> getRecipeByName(@RequestParam(value = "recipeName") String recipeName) {
		Optional<Recipe> recipe = customerDaoService.getRecipeByName(recipeName);
		if (recipe.isEmpty()) {
			throw new RecipeNotFoundException("Recipe Not Found with recipeName: "+recipeName);
		}
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@GetMapping("/getRecipeByType")
	public ResponseEntity<Object> getRecipeByType(@RequestParam(value = "isVegetarian") Boolean isVegetarian) {
		List<Optional<Recipe>> recipe = customerDaoService.getRecipeByType(isVegetarian);
		if (recipe.isEmpty()) {
			throw new RecipeNotFoundException("Recipe Not Found with Type isVegetarian: "+isVegetarian);
		}
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@GetMapping("/getRecipeByServingSize")
	public ResponseEntity<Object> getRecipeByServingSize(@RequestParam(value = "servingSize") Integer servingSize) {
		List<Optional<Recipe>> recipe = customerDaoService.getRecipeByServingSize(servingSize);
		if (recipe.isEmpty()) {
			throw new RecipeNotFoundException("Recipe Not Found with servingSize: "+servingSize);
		}
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@GetMapping("/getRecipeList")
	public ResponseEntity<Object> getRecipeList() {
		List<Recipe> recipe = customerDaoService.getRecipeList();
		if (recipe.isEmpty()) {
			throw new RecipeNotFoundException("Recipe List is Empty");
		}
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@PostMapping("/UpdateRecipeById")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseEntity<Object> updateRecipeById(@RequestBody Recipe recipe) {
		if (recipe.getId() == null) {
			throw new RecipeIdNotFoundException("Recipe Id is compulsory to update the recipe");
		} else {
			Optional<Recipe> result = customerDaoService.getRecipeById(recipe.getId());
			if (result.isEmpty()) {
				throw new RecipeNotFoundException("Recipe Not Found with Id: "+recipe.getId());
			} else {
			if (recipe.getRecipeName() == null) {
				recipe.setRecipeName(result.get().getRecipeName());
			}
			if (recipe.getCreateDate() == null) {
				recipe.setCreateDate(result.get().getCreateDate());
			}
			if (recipe.getIsVegetarian() == null) {
				recipe.setIsVegetarian(result.get().getIsVegetarian());
			}
			if (recipe.getServingSize() == null) {
				recipe.setServingSize(result.get().getServingSize());
			}
			if (recipe.getIngredients() == null) {
				recipe.setIngredients(result.get().getIngredients());
			}
			if (recipe.getCookingInstructions() == null) {
				recipe.setCookingInstructions(result.get().getCookingInstructions());
			}
			}
		}
		createRecipe(recipe);
		Optional<Recipe> updatedRecipe = customerDaoService.getRecipeById(recipe.getId());

		return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRecipeById")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseEntity<Object> deleteRecipeById(@RequestParam(value = "id") Long id) {
		if (id == null) {
			throw new RecipeIdNotFoundException("Recipe Id is compulsory to delete the recipe");
		}
		Optional<Recipe> result = customerDaoService.getRecipeById(id);
		if (result.isEmpty()) {
			throw new RecipeNotFoundException("Recipe Not Found with Id:"+id);
		}
		customerDaoService.deleteRecipeById(id);
		return new ResponseEntity<>("Deleted Id: "+id, HttpStatus.OK);
	}
}
