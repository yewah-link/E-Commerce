package com.example.ELtonSmartWare.controller;

import com.example.ELtonSmartWare.dto.CategoryDTO;
import com.example.ELtonSmartWare.dto.ProductDTO;
import com.example.ELtonSmartWare.entity.Category;
import com.example.ELtonSmartWare.entity.Product;
import com.example.ELtonSmartWare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/admin")

public class AdminController {

    @Autowired

    private AdminService adminService;
    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO){


        Category createdcategory = adminService.createCategory(categoryDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdcategory);

    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> allCategories = adminService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }
    @PostMapping("/product/{categoryId}")
    public ResponseEntity<Product> postProduct(@PathVariable Long categoryId, @ModelAttribute ProductDTO productDTO)throws Exception{
        Product postedProduct =adminService.postProduct(categoryId,productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(postedProduct);

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
    @PutMapping("/{categoryId}/product/{productId}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long categoryId,
            @PathVariable Long productId,
            @ModelAttribute ProductDTO productDto) throws IOException {
        ProductDTO updateProduct = adminService.updateProduct(categoryId,productId,productDto);
        if(updateProduct==null)return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        return ResponseEntity.ok(updateProduct);
    }


}
