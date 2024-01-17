package com.example.buysellboard.services;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.dtos.product.ProductDTO;
import com.example.buysellboard.entities.Product;
import com.example.buysellboard.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
     *
     * @param insertProductDTO The data transfer object containing information about the new product.
     */
    public Product addProduct(InsertProductDTO insertProductDTO) {
        return productRepository.saveAndFlush(modelMapper.map(insertProductDTO, Product.class));
    }

    /**
     * Retrieves a product from the database based on its unique identifier.
     *
     * @param id The unique identifier (UUID) of the product to retrieve.
     * @return The Product entity associated with the given identifier, or null if not found.
     */
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a product from the repository based on its title.
     *
     * @param title The title of the product to be retrieved.
     * @return Optional containing the retrieved product or empty if not found.
     */
    public Optional<Product> getProductByTitle(String title) {

        // Check if the title is not null, then retrieve the product by title
        return Optional.ofNullable(title)
                .flatMap(productRepository::getProductByTitle);
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return List of Optional ProductDTOs representing the mapped products
     */
    public List<Optional<ProductDTO>> getAllProducts() {
        var productDTOS = productRepository.findAll();

        // Map each product to its corresponding DTO and collect the results in a List
        return productDTOS.stream().map(arg -> mapToDTO(Optional.of(arg))).toList();
    }

    /**
     * Deletes a product from the database using its unique identifier.
     */
    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    /**
     * Maps a Product entity to a corresponding ProductDTO using the modelMapper.
     * Maps an Optional of Product to an Optional of ProductDTO using ModelMapper.
     * @param product Optional of Product to be mapped
     * @return Optional of ProductDTO, representing the mapped result
     */
    public Optional<ProductDTO> mapToDTO(Optional<Product> product) {
        return Optional.of(modelMapper.map(product, ProductDTO.class));
    }
}
