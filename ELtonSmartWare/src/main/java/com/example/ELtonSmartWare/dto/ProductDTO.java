package com.example.ELtonSmartWare.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDTO {
    private Long id;

    private String name;

    private  String description;

    private Double price;

    private MultipartFile image;

    private Long categoryId;

    private byte[] returnedImage;

    private String categoryName;

}
