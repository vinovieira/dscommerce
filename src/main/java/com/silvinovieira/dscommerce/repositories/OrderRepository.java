package com.silvinovieira.dscommerce.repositories;

import com.silvinovieira.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
