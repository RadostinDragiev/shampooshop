package com.example.shampooshop;

import com.example.shampooshop.services.IngredientsService;
import com.example.shampooshop.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientsService ingredientsService;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientsService ingredientsService) {
        this.shampooService = shampooService;
        this.ingredientsService = ingredientsService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 1. Select Shampoos by Size
        //this.shampooService.getAllShampoosBySize(Size.valueOf(input))
        //        .forEach(shampoo -> System.out.printf("%s %s %.2f%n", shampoo.getBrand(), shampoo.getSize().toString(), shampoo.getPrice()));

        // 2. Select Shampoos by Size or Label
        //this.shampooService.getAllShampoosBySizeOrLabel(Size.valueOf(input), 10)
        //        .forEach(shampoo -> System.out.printf("%s %s %.2f%n", shampoo.getBrand(), shampoo.getSize().toString(), shampoo.getPrice()));

        // 3. Select Shampoos by Price
        //this.shampooService.getAllShampooHigherThan(new BigDecimal(input))
        //        .forEach(shampoo -> System.out.printf("%s %s %.2f%n", shampoo.getBrand(), shampoo.getSize().toString(), shampoo.getPrice()));

        // 4. Select Ingredients by Name
        //this.ingredientsService.getAllIngredientsStartingWith(input)
        //        .forEach(ingredient -> System.out.println(ingredient.getName()));

        // 5. Select Ingredients by Names
        //this.ingredientsService.getAllIngredientsFromList(Arrays.asList("Lavender", "Herbs", "Apple"))
        //        .forEach(ingredient -> System.out.println(ingredient.getName()));

        // 6. Count Shampoos by Price
        //System.out.println(this.shampooService.getShampooCountWithLessPrice(new BigDecimal(input)));

        // 7. Select Shampoos by Ingredients
        //this.shampooService.getShampoosByIngredients(new HashSet<>(Arrays.asList("Berry", "Mineral-Collagen")))
        //        .forEach(shampoo -> System.out.println(shampoo.getBrand()));

        // 8. Select Shampoos by Ingredients Count
        //this.shampooService.getShampoosByIngredientsSize(Integer.parseInt(input))
        //        .forEach(shampoo -> System.out.println(shampoo.getBrand()));

        // 9. Delete Ingredients by Name
        //System.out.println(this.shampooService.deleteShampooByBrand(input));

        // 10. Update Ingredients by Price
        //System.out.println(this.ingredientsService.updateIngredientsPrice(new BigDecimal(input)));

        //11. Update Ingredients by Names
        //System.out.println(this.ingredientsService.updateIngredientsPriceFromList(Arrays.asList("Lavender", "Herbs", "Apple")));
    }
}
