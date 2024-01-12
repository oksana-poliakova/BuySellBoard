package com.example.buysellboard.controllers;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.dtos.product.ProductDTO;
import com.example.buysellboard.entities.Product;
import com.example.buysellboard.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 * Controller class for handling product-related web requests.
 */

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products() {
        return "products";
    }

    /**
     * Controller method for handling POST requests to add a product to the database.
     * @param insertProductDTO The data transfer object containing information about the new product.
     * @return The ProductDTO representing the newly added product.
     */
    @PostMapping("/addProduct")
    @Operation(summary = "Possibility to add a product to the database")
    public ProductDTO addProduct(@Valid @RequestBody InsertProductDTO insertProductDTO) {
        return productService.mapToDTO(productService.addProduct(insertProductDTO));
    }

    /**
     * Controller method for handling GET requests to retrieve all products from the database.
     * @return A List of Product entities representing all products in the database.
     */
    @GetMapping("/getAllProducts")
    @Operation(summary = "Possibility to get all products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Controller method for handling DELETE requests to delete a product from the database by its ID.
     * @param product product The Product entity to be deleted from the database.
     */
    @DeleteMapping("/deleteById")
    @Operation(summary = "Possibility to delete a product by id")
    public void deleteProductById(Product product) {
        productService.deleteProductById(product);
    }
}
