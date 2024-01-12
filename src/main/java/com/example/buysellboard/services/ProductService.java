package com.example.buysellboard.services;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.dtos.product.ProductDTO;
import com.example.buysellboard.entities.Product;
import com.example.buysellboard.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public Product addProduct(InsertProductDTO insertProductDTO) {
        var product = modelMapper.map(insertProductDTO, Product.class);

        return productRepository.saveAndFlush(product);
    }

    public ProductDTO mapToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
