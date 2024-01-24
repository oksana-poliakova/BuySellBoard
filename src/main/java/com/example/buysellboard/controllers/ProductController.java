package com.example.buysellboard.controllers;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.dtos.product.ProductDTO;
import com.example.buysellboard.entities.Product;
import com.example.buysellboard.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Optional<ProductDTO> createProduct(@RequestParam("file1") MultipartFile file1,
                                              @RequestParam("file2") MultipartFile file2,
                                              @RequestParam("file3") MultipartFile file3,
                                              @Valid @RequestBody InsertProductDTO insertProductDTO) throws IOException {
        return productService.mapToDTO(productService.addProduct(insertProductDTO, file1, file2, file3));
    }

    @GetMapping("/getProductById/{productId}")
    @Operation(summary = "Get a product by id")
    public Product getProductById(@PathVariable("productId") UUID productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/getProductByTitle/{title}")
    @Operation(summary = "Get a product by title")
    public Optional<ProductDTO> getProductByTitle(@PathVariable("title") String title) {
        var product = productService.getProductByTitle(title);
        return productService.mapToDTO(product.get());
    }

    @GetMapping("/getAllProducts")
    @Operation(summary = "Get a list of all products")
    public List<Optional<ProductDTO>> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/delete/{product}")
    @Operation(summary = "Delete a product by id")
    public void deleteProductById(@PathVariable("product") UUID id) {
        productService.deleteProductById(id);
    }
}
