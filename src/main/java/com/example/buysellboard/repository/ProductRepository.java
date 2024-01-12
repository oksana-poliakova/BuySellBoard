package com.example.buysellboard.repository;

import com.example.buysellboard.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 * Repository interface for managing Product entities in the database.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
