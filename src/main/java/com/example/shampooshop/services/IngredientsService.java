package com.example.shampooshop.services;

import com.example.shampooshop.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientsService {
    List<Ingredient> getAllIngredientsStartingWith(String startWith);

    List<Ingredient> getAllIngredientsFromList(List<String> ingredients);

    int updateIngredientsPrice(BigDecimal percentage);

    int updateIngredientsPriceFromList(List<String> names);
}
