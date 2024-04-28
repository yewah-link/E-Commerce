package com.example.ELtonSmartWare.repository;

import com.example.ELtonSmartWare.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}


