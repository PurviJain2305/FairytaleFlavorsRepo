package com.example.FairytaleFlavors.integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.FairytaleFlavors.FairytaleFlavorsApplication;
import com.example.FairytaleFlavors.bean.Recipe;
import com.example.FairytaleFlavors.repository.RecipeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = FairytaleFlavorsApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")
public class RecipeRepositoryTest {
	
	@Autowired
    private MockMvc mvc;

    @Autowired
    private RecipeRepository repository;
	
	@Test
    public void givenRecipeObjectThenSaveDataIntoRepository() throws Exception {
    	
    	repository.save(getRecipeObject().get());
    	
    	ResultActions resultActions = mvc.perform(get("/getRecipeById?id=1").contentType(MediaType.APPLICATION_JSON));
    	System.out.println("Created row:" + resultActions.andReturn().getResponse().getContentAsString());
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
