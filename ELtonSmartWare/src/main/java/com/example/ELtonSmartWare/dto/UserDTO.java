package com.example.ELtonSmartWare.dto;

import com.example.ELtonSmartWare.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private  Long id;

    private  String email;

    private  String  name;

    private UserRole userRole;

}
