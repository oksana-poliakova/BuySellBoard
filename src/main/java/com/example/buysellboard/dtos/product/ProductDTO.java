package com.example.buysellboard.dtos.product;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 */

@Data
public class ProductDTO {
    private UUID id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;
}
