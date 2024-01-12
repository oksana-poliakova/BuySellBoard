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
import java.util.UUID;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 * Service class responsible for managing product-related operations.
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

    /**
     * Adds a new product to the database based on the information provided in the InsertProductDTO.
     * @param insertProductDTO  The data transfer object containing information about the new product.
     * @return The newly added Product object.
     * @throws IllegalArgumentException if the insertProductDTO is null.
     */
    public Product addProduct(InsertProductDTO insertProductDTO) {
        if (insertProductDTO == null) {
            throw new IllegalArgumentException("insertProductDTO must not be null");
        }

        var product = modelMapper.map(insertProductDTO, Product.class);

        return productRepository.saveAndFlush(product);
    }

    /**
     * Retrieves a list of all products from the database.
     * @return A List of Product objects representing all products in the database.
     * If no products are found, an empty list is returned.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Deletes a product from the database using its unique identifier.
     * @param product The Product entity to be deleted from the database.
     */
    public void deleteProductById(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        productRepository.deleteById(product.getId());
    }

    /**
     * Maps a Product entity to a corresponding ProductDTO using the modelMapper.
     * @param product The Product entity to be mapped to a ProductDTO.
     * @return The mapped ProductDTO representing the same information as the input Product.
     * @throws IllegalArgumentException if the input Product is null.
     */
    public ProductDTO mapToDTO(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product must not be null");
        }

        return modelMapper.map(product, ProductDTO.class);
    }
}
