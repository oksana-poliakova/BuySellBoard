package com.example.buysellboard.controllers;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.dtos.product.ProductDTO;
import com.example.buysellboard.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @PostMapping("/add")
    @Operation(summary = "Posibility to add a product to the database")
    public ProductDTO save(@Valid @RequestBody InsertProductDTO insertProductDTO) {
        return productService.mapToDTO(productService.addProduct(insertProductDTO));
    }
}
