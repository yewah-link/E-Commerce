package com.example.ELtonSmartWare.service;

import com.example.ELtonSmartWare.dto.SignupRequest;
import com.example.ELtonSmartWare.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface AuthService {

    UserDTO createUser(SignupRequest signupRequest);

}
