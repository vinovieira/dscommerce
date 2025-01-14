package com.silvinovieira.dscommerce.services;

import com.silvinovieira.dscommerce.dto.OrderDTO;
import com.silvinovieira.dscommerce.dto.ProductDTO;
import com.silvinovieira.dscommerce.entities.Order;
import com.silvinovieira.dscommerce.entities.Product;
import com.silvinovieira.dscommerce.repositories.OrderRepository;
import com.silvinovieira.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
