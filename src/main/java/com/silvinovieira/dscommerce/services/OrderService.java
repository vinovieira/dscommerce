package com.silvinovieira.dscommerce.services;

import com.silvinovieira.dscommerce.dto.OrderDTO;
import com.silvinovieira.dscommerce.dto.OrderItemDTO;
import com.silvinovieira.dscommerce.entities.*;
import com.silvinovieira.dscommerce.repositories.OrderItemRepository;
import com.silvinovieira.dscommerce.repositories.OrderRepository;
import com.silvinovieira.dscommerce.repositories.ProductRepository;
import com.silvinovieira.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        authService.validateSelfOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert( OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);
        for (OrderItemDTO item : dto.getItems()){
            Product product = productRepository.getReferenceById(item.getProductId());
            OrderItem orderItem = new OrderItem(product, order, item.getQuantity(), product.getPrice());
            order.getItems().add(orderItem);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
