package com.example.FairytaleFlavors.bean;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	
	private String recipeName;
	private String createDate;
	private Boolean isVegetarian;
	private Integer servingSize;
	@ElementCollection
	private List<String> ingredients;
	@ElementCollection
	private List<String> cookingInstructions;
	@JsonIgnore
	private String updatedDate;

	public Recipe() {
	}
	
	public Recipe(String recipeName, Boolean isVegetarian, Integer servingSize,
			List<String> ingredients, List<String> cookingInstructions) {
		super();
		this.recipeName = recipeName;
		this.isVegetarian = isVegetarian;
		this.servingSize = servingSize;
		this.ingredients = ingredients;
		this.cookingInstructions = cookingInstructions;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Boolean getIsVegetarian() {
		return isVegetarian;
	}

	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	
	public Integer getServingSize() {
		return servingSize;
	}
	
	public void setServingSize(Integer servingSize) {
		this.servingSize = servingSize;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<String> getCookingInstructions() {
		return cookingInstructions;
	}

	public void setCookingInstructions(List<String> cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeName=" + recipeName + ", createDate=" + createDate + ", isVegetarian="
				+ isVegetarian + ", servingSize=" + servingSize + ", ingredients=" + ingredients
				+ ", cookingInstructions=" + cookingInstructions + ", updatedDate=" + updatedDate + "]";
	}

}
