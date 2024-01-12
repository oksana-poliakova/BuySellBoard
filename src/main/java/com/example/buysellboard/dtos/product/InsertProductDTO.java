package com.example.buysellboard.dtos.product;

import lombok.Data;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 */
@Data
public class InsertProductDTO {
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;
}
