package com.example.ELtonSmartWare.service;

import com.example.ELtonSmartWare.dto.CategoryDTO;
import com.example.ELtonSmartWare.dto.ProductDTO;
import com.example.ELtonSmartWare.entity.Category;
import com.example.ELtonSmartWare.entity.Product;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    Category createCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategories();

    Product postProduct(Long categoryId, ProductDTO productDto) throws IOException;

    List<ProductDTO> getAllProducts();

    void deleteProduct(Long id);

    ProductDTO updateProduct(Long id);

    ProductDTO updateProduct(Long categoryId, Long productId, ProductDTO productDTO) throws IOException;
}
