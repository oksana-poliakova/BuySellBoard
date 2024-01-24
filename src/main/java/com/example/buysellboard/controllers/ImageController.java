package com.example.buysellboard.controllers;

import com.example.buysellboard.entities.Image;
import com.example.buysellboard.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.UUID;

/**
 * @author oksanapoliakova on 24.01.2024
 * @projectName BuySellBoard
 */

@RestController
@AllArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    // Handling HTTP GET requests for retrieving an image by its ID
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable UUID id) {
        Image image = imageRepository.findById(id).orElse(null);

        // If the image is not found, return a 404 response
        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        // Constructing an HTTP response with image information and its content
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
