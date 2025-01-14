package com.silvinovieira.dscommerce.repositories;

import com.silvinovieira.dscommerce.entities.Order;
import com.silvinovieira.dscommerce.entities.OrderItem;
import com.silvinovieira.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
