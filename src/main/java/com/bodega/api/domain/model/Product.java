package com.bodega.api.domain.model;

import com.bodega.api.domain.exceptions.DomainRuleException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private Category category;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String image;
    private Integer discount;
    private Boolean active;

    public Product(Category category, String name, String description, BigDecimal price, Integer stock, String image, Integer discount, Boolean active) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.discount = discount;
        this.active = active;
    }

    public static Product create(Category category, String name, String description, BigDecimal price, Integer stock, String image, Integer discount) {
        if (category == null) {
            throw new DomainRuleException("Product category is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new DomainRuleException("Product name is required");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainRuleException("Product price must be valid");
        }
        if (stock == null || stock < 0) {
            throw new DomainRuleException("Product stock cannot be negative");
        }

        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setImage(image);
        product.setDiscount(discount != null ? discount : 0);
        product.setActive(true);
        return product;
    }
}