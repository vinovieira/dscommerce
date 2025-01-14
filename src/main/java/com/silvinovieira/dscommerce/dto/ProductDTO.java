package com.silvinovieira.dscommerce.dto;

import com.silvinovieira.dscommerce.entities.Category;
import com.silvinovieira.dscommerce.entities.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    private String name;

    @NotBlank(message = "Campo requerido")
    @Size(min = 10, message = "Descrição precisa ter mais de 10 caracteres")
    private String description;

    @NotNull(message = "Campo requerido")
    @Positive(message = "Preço deve ser positivo")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Necessário pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {}

    public ProductDTO(Long id, String imgUrl, Double price, String description, String name) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for (Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
