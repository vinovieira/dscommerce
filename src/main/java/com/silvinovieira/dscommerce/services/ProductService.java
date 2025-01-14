package com.silvinovieira.dscommerce.services;

import com.silvinovieira.dscommerce.dto.CategoryDTO;
import com.silvinovieira.dscommerce.dto.ProductDTO;
import com.silvinovieira.dscommerce.dto.ProductMinDTO;
import com.silvinovieira.dscommerce.entities.Category;
import com.silvinovieira.dscommerce.entities.Product;
import com.silvinovieira.dscommerce.repositories.ProductRepository;
import com.silvinovieira.dscommerce.services.exceptions.DatabaseException;
import com.silvinovieira.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
        Page<Product> products = repository.searchByName(name, pageable);
        return products.map(x -> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product product = new Product();
        copyDtoToEntity(dto, product);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product product = repository.getReferenceById(id);
        copyDtoToEntity(dto, product);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());
        product.getCategories().clear();
        for (CategoryDTO CatDto : dto.getCategories()) {
            Category cat = new Category();
            cat.setId(CatDto.getId());
            product.getCategories().add(cat);
        }
    }


}
