package com.example.webshopapi.seeder;

import com.example.webshopapi.JwtAuthentication.Role;
import com.example.webshopapi.dao.UserDAO;
import com.example.webshopapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
public class UserSeeder {
    @Autowired
    private UserDAO userDAO;

    private final PasswordEncoder passwordEncoder;

    public UserSeeder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public void seed() {
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setEmail("marc@gmail.com");
        user1.setPassword(passwordEncoder.encode("Admin1234"));
        user1.setRole(Role.ADMIN);
        userDAO.save(user1);

    }
}
