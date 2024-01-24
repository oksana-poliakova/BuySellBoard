package com.example.buysellboard.repository;

import com.example.buysellboard.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author oksanapoliakova on 24.01.2024
 * @projectName BuySellBoard
 */

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

}
