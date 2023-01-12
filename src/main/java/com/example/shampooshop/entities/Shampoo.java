package com.example.shampooshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "shampoos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private Size size;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Label label;
    @ManyToMany
    private Set<Ingredient> ingredients;

}
