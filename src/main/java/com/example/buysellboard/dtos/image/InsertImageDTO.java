package com.example.buysellboard.dtos.image;

import jakarta.persistence.Lob;
import lombok.Data;

/**
 * @author oksanapoliakova on 24.01.2024
 * @projectName BuySellBoard
 */

@Data
public class InsertImageDTO {
    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;
    private boolean isPreviewImage;
    private byte[] bytes;
}
