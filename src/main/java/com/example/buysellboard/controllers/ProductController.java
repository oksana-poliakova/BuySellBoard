package com.example.buysellboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 */

@Controller
public class ProductController {
    @GetMapping("/")
    public String products() {
        return "products";
    }
}
