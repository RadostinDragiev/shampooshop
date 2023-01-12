package com.example.shampooshop.repositories;

import com.example.shampooshop.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String startWith);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> ingredients);

    @Modifying
    @Query("UPDATE Ingredient AS i SET i.price = i.price * :percentage")
    int updateIngredientsPrice(BigDecimal percentage);

    @Modifying
    @Query("UPDATE Ingredient AS i SET i.price = i.price * 1.10 WHERE i.name IN :ingredientsNames")
    int updateIngredientsPriceFromList(List<String> ingredientsNames);
}
