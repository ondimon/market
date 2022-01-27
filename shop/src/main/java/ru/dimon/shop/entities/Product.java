package ru.dimon.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "products_categories",
              joinColumns = @JoinColumn(name = "product_id"),
              inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
}
