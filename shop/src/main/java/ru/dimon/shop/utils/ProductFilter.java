package ru.dimon.shop.utils;


import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.dimon.shop.entities.Product;
import ru.dimon.shop.repositories.specifications.ProductSpecifications;

import java.util.Map;

@Getter
public class ProductFilter {
    private Specification<Product> spec;
    private StringBuilder filterDefinition;

    public ProductFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            int minPrice = Integer.parseInt(map.get("min_price"));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
            filterDefinition.append("&min_price=").append(minPrice);
        }
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            int maxPrice = Integer.parseInt(map.get("max_price"));
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(maxPrice));
            filterDefinition.append("&max_price=").append(maxPrice);
        }
        if (map.containsKey("title") && !map.get("title").isEmpty()) {
            String title = map.get("title");
            spec = spec.and(ProductSpecifications.titleLike(title));
            filterDefinition.append("&title=").append(title);
        }

        if (map.containsKey("category") && !map.get("category").isEmpty()) {
            Long categoryId = Long.parseLong(map.get("category"));
            spec = spec.and(ProductSpecifications.categoryIn(categoryId));
            filterDefinition.append("&category=").append(categoryId);
        }
    }
}
