package com.example.buysellboard.controllers;

import com.example.buysellboard.dtos.product.InsertProductDTO;
import com.example.buysellboard.entities.Product;
import com.example.buysellboard.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    /**
     * Controller method for handling HTTP GET requests to retrieve and display all products.
     * @param model The Spring MVC Model object used to pass data to the view.
     * @return
     */
    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/getByTitle")
    public String getProductByTitle(@RequestParam(name = "searchByTitle", required = false) String title, Model model) {
        Optional<Product> products = productService.getProductByTitle(title);
        model.addAttribute("products", products.orElse(null));
        return "products";
    }

    /**
     * Controller method for handling POST requests to add a product to the database.
     * @param insertProductDTO The data transfer object containing information about the new product.
     * @return The ProductDTO representing the newly added product.
     */
    @PostMapping("/product/create")
    public String createProduct(@ModelAttribute InsertProductDTO insertProductDTO) {
        productService.addProduct(insertProductDTO);
        return "redirect:/getAllProducts";
    }

    /**
     * Controller method for handling GET requests to retrieve all products from the database.
     * @param model The Spring MVC Model object used to pass data to the view.
     * @return The name of the view template ("get_all_products") that will be rendered to display all products.
     */
    @GetMapping("/getAllProducts")
    public String getAllProducts(Model model) {
        model.addAttribute("getAllProducts", productService.getAllProducts());
        return "get_all_products";
    }

    /**
     *  * Controller method for handling GET requests to retrieve detailed information about a product by its unique identifier.
     * @param id The unique identifier of the product to retrieve, provided as a path variable.
     * @param model The Spring MVC Model object used to pass data to the view.
     * @return The name of the view template ("product_info") that will be rendered to display detailed product information.
     */
    @GetMapping("/product/{id}")
    public String getProductInfo(@PathVariable UUID id, Model model) {
        model.addAttribute("product_info", productService.getProductById(id));
        return "product_info";
    }

    /**
     * Controller method for handling DELETE requests to delete a product from the database by its ID.
     * @param product product The Product entity to be deleted from the database.
     * @return A redirection to the "/products" endpoint after the deletion operation.
     */
    @PostMapping("/product/delete/{product}")
    public String deleteProductById(@PathVariable Product product) {
        productService.deleteProductById(product);
        return "redirect:/products";
    }
}
