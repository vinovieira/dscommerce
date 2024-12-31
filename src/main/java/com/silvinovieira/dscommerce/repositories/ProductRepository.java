package com.silvinovieira.dscommerce.repositories;

import com.silvinovieira.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
