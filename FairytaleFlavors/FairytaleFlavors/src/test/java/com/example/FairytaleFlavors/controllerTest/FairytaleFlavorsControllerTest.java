package com.example.FairytaleFlavors.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.FairytaleFlavors.FairytaleFlavorsApplication;
import com.example.FairytaleFlavors.bean.Recipe;
import com.example.FairytaleFlavors.controller.FairytaleFlavorsController;
import com.example.FairytaleFlavors.service.CustomerDaoService;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = FairytaleFlavorsApplication.class)
public class FairytaleFlavorsControllerTest {
	
	@Autowired
	private FairytaleFlavorsController theFairytaleFlavorsController;
	
	@MockBean
	private CustomerDaoService mockCustomerDaoService;
	
	@Test
	public void givenRecipeObjectthenCreateRecipe() {
		
		Recipe mockRecipe = getRecipeObject().get();
		
		theFairytaleFlavorsController.createRecipe(mockRecipe);
		
		verify(mockCustomerDaoService, times(1)).insert(mockRecipe);
	}
	
	@Test
	public void givenRecipeIdthenGetRecipeById() {
		
		Long expectedId = (long) 1;
		
		when(mockCustomerDaoService.getRecipeById(expectedId)).thenReturn(getRecipeObject());
		
		theFairytaleFlavorsController.getRecipeById(expectedId);
		
		verify(mockCustomerDaoService, times(1)).getRecipeById(expectedId);
	}
	
	@Test
	public void givenRecipeNamethenGetRecipeByName() {
		
		String expectedRecipeName = "Kabab";
		
		when(mockCustomerDaoService.getRecipeByName(expectedRecipeName)).thenReturn(getRecipeObject());
		
		theFairytaleFlavorsController.getRecipeByName(expectedRecipeName);
		
		verify(mockCustomerDaoService, times(1)).getRecipeByName(expectedRecipeName);
	}
	
	@Test
	public void givenRecipeTypethenGetRecipeByType() {
		
		Boolean expectedIsVegetarian = true;
		
		when(mockCustomerDaoService.getRecipeByType(expectedIsVegetarian)).thenReturn(List.of(getRecipeObject()));
		
		theFairytaleFlavorsController.getRecipeByType(expectedIsVegetarian);
		
		verify(mockCustomerDaoService, times(1)).getRecipeByType(expectedIsVegetarian);
	}
	
	@Test
	public void givenRecipeServingSizethenGetRecipeByServingSize() {
		
		Integer expectedServingSize = 4;
		
		when(mockCustomerDaoService.getRecipeByServingSize(expectedServingSize)).thenReturn(List.of(getRecipeObject()));
		
		theFairytaleFlavorsController.getRecipeByServingSize(expectedServingSize);
		
		verify(mockCustomerDaoService, times(1)).getRecipeByServingSize(expectedServingSize);
	}
	
	@Test
	public void givenRecipethenGetRecipeList() {
		
		when(mockCustomerDaoService.getRecipeList()).thenReturn(List.of(getRecipeObject().get()));
		
		theFairytaleFlavorsController.getRecipeList();
		
		verify(mockCustomerDaoService, times(1)).getRecipeList();
	}
	
	@Test
	public void givenRecipeIdthenUpdateRecipeById() {
		
		Long expectedId = 1l;
		
		Recipe recipe = getRecipeObject().get();
		recipe.setId(1l);
		when(mockCustomerDaoService.getRecipeById(expectedId)).thenReturn(Optional.of(recipe));
		
		theFairytaleFlavorsController.updateRecipeById(recipe);
		
		verify(mockCustomerDaoService, times(2)).getRecipeById(expectedId);
		verify(mockCustomerDaoService, times(1)).insert(recipe);
	}
	
	@Test
	public void givenRecipeIdthenDeleteRecipeById() {
		
		Long expectedId = 1l;
		
		when(mockCustomerDaoService.getRecipeById(expectedId)).thenReturn(getRecipeObject());
		
		theFairytaleFlavorsController.deleteRecipeById(expectedId);
		
		verify(mockCustomerDaoService, times(1)).getRecipeById(expectedId);
		verify(mockCustomerDaoService, times(1)).deleteRecipeById(expectedId);
	}
	
	
	public Optional<Recipe> getRecipeObject () {
		List<String> ingredients = new ArrayList<String>();
		List<String> cookingInstructions = new ArrayList<String>();
		ingredients.add("oil");
		ingredients.add("cumin");
		cookingInstructions.add("heat");
		cookingInstructions.add("boil");
		return Optional.of(new Recipe("Kabab", true, 4, ingredients, cookingInstructions));
	}
}
