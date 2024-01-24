package com.example.buysellboard.dtos.product;

import com.example.buysellboard.entities.Image;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private Long previewImageId;
    private LocalDateTime dateOfCreated;
    private List<Image> imageList = new ArrayList<>();

}
