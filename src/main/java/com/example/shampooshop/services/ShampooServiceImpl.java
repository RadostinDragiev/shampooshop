package com.example.shampooshop.services;

import com.example.shampooshop.entities.Shampoo;
import com.example.shampooshop.entities.Size;
import com.example.shampooshop.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> getAllShampoosBySize(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> getAllShampoosBySizeOrLabel(Size size, long id) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, id);
    }

    @Override
    public List<Shampoo> getAllShampooHigherThan(BigDecimal amount) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(amount);
    }

    @Override
    public int getShampooCountWithLessPrice(BigDecimal price) {
        return this.shampooRepository.countShampooByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> getShampoosByIngredients(Set<String> ingredients) {
        return this.shampooRepository.getAllShampoosByIngredients(ingredients);
    }

    @Override
    public List<Shampoo> getShampoosByIngredientsSize(int count) {
        return this.shampooRepository.getAllShampoosWithLessCountOfIngredients(count);
    }

    @Override
    @Transactional
    public int deleteShampooByBrand(String brand) {
        return this.shampooRepository.deleteCount(brand);
    }
}
