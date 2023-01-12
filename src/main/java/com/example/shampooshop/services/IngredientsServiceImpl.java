package com.example.shampooshop.services;

import com.example.shampooshop.entities.Ingredient;
import com.example.shampooshop.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Ingredient> getAllIngredientsStartingWith(String startWith) {
        return this.ingredientsRepository.findAllByNameStartingWith(startWith);
    }

    @Override
    public List<Ingredient> getAllIngredientsFromList(List<String> ingredients) {
        return this.ingredientsRepository.findAllByNameInOrderByPrice(ingredients);
    }

    @Override
    @Transactional
    public int updateIngredientsPrice(BigDecimal percentage) {
        return this.ingredientsRepository.updateIngredientsPrice(percentage);
    }

    @Override
    @Transactional
    public int updateIngredientsPriceFromList(List<String> names) {
        return this.ingredientsRepository.updateIngredientsPriceFromList(names);
    }
}
