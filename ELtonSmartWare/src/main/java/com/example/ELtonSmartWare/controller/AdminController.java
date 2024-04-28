package com.example.ELtonSmartWare.controller;

import com.example.ELtonSmartWare.dto.ProductDTO;
import com.example.ELtonSmartWare.entity.Product;
import com.example.ELtonSmartWare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDtoList = adminService.getAllProducts();
        return ResponseEntity.ok(productDtoList);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        adminService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id){
        ProductDTO productDto = adminService.updateProduct(id);
        if(productDto == null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDto);
    }

    // Implement get methods similarly if needed

}

