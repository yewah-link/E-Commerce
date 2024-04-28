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


    // Implement get methods similarly if needed

}

