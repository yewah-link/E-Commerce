package com.example.ELtonSmartWare.service;

import com.example.ELtonSmartWare.dto.SignupRequest;
import com.example.ELtonSmartWare.dto.UserDTO;
import com.example.ELtonSmartWare.entity.User; // Import your User entity class
import com.example.ELtonSmartWare.enums.UserRole;
import com.example.ELtonSmartWare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;



@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());

        return userDTO;
    }

    public boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @PostMapping
    public void createAdminAccount(){
        if (userRepository.findByRole(UserRole.ADMIN) == null) {
            User admin = new User();
            admin.setEmail("admin@test.com");
            admin.setName("admin");
            admin.setRole(UserRole.ADMIN);
            admin.setPassword(bCryptPasswordEncoder.encode("admin"));
            userRepository.save(admin);
        }
    }
}
