package com.silvinovieira.dscommerce.repositories;

import com.silvinovieira.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
