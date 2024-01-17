package com.example.buysellboard.controllers;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.dtos.product.ProductDTO;
import com.example.buysellboard.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 * Controller class for handling product-related web requests.
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    @Operation(summary = "Possibility to add product to the database")
    public Optional<ProductDTO> createProduct(@Valid @RequestBody InsertProductDTO insertProductDTO) {
        return productService.mapToDTO(Optional.ofNullable(productService.addProduct(insertProductDTO)));
    }

    /**
     * FIXME: Error - response status is 500
     * */
    @GetMapping("/{productId}")
    @Operation(summary = "Get a product by id")
    public Optional<ProductDTO> getProductById(@PathVariable("productId") UUID productId) {
        var product = productService.getProductById(productId);
        return productService.mapToDTO(Optional.ofNullable(product));
    }

    /**
     * FIXME: Error - response status is 500
     * */
    @GetMapping("/{title}")
    @Operation(summary = "Get a product by title")
    public Optional<ProductDTO> getProductByTitle(@PathVariable("title") String title) {
        var product = productService.getProductByTitle(title);
        return productService.mapToDTO(product);
    }

    /**
     * FIXME: Error - Getting only an empty list without products
     * */
    @GetMapping("/getAllProducts")
    @Operation(summary = "Get a list of all products")
    public List<Optional<ProductDTO>> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * FIXME: Doesn't work deleting from the database
     * */
    @PostMapping("/delete/{product}")
    @Operation(summary = "Delete a product by id")
    public void deleteProductById(@PathVariable("product") UUID id) {
        productService.deleteProductById(id);
    }
}
