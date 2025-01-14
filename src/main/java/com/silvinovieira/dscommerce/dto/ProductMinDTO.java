package com.silvinovieira.dscommerce.dto;

import com.silvinovieira.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ProductMinDTO() {}

    public ProductMinDTO(Long id, String imgUrl, Double price, String description, String name) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.price = price;
        this.name = name;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
