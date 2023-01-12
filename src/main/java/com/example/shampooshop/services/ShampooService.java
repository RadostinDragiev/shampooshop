package com.example.shampooshop.services;

import com.example.shampooshop.entities.Shampoo;
import com.example.shampooshop.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> getAllShampoosBySize(Size size);

    List<Shampoo> getAllShampoosBySizeOrLabel(Size size, long id);

    List<Shampoo> getAllShampooHigherThan(BigDecimal amount);

    int getShampooCountWithLessPrice(BigDecimal price);

    List<Shampoo> getShampoosByIngredients(Set<String> ingredients);

    List<Shampoo> getShampoosByIngredientsSize(int count);

    int deleteShampooByBrand(String brand);
}
