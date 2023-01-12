package com.example.shampooshop.repositories;

import com.example.shampooshop.entities.Shampoo;
import com.example.shampooshop.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, long id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal amount);

    Integer countShampooByPriceLessThan(BigDecimal amount);

    @Query("SELECT s FROM Shampoo AS s INNER JOIN s.ingredients AS ing WHERE ing.name IN :ingredients")
    List<Shampoo> getAllShampoosByIngredients(Set<String> ingredients);

    @Query("SELECT s FROM Shampoo AS s WHERE s.ingredients.size < :count")
    List<Shampoo> getAllShampoosWithLessCountOfIngredients(int count);

    @Modifying
    @Query("DELETE FROM Shampoo AS s WHERE s.brand = :name")
    int deleteCount(String name);
}
