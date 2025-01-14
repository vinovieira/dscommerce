package com.silvinovieira.dscommerce.services;

import com.silvinovieira.dscommerce.dto.CategoryDTO;
import com.silvinovieira.dscommerce.dto.ProductMinDTO;
import com.silvinovieira.dscommerce.entities.Category;
import com.silvinovieira.dscommerce.entities.Product;
import com.silvinovieira.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
