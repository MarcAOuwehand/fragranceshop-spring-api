package com.example.webshopapi.dao;

import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> all() {
        ArrayList<User> allUsers = (ArrayList<User>) this.userRepository.findAll();
        return allUsers;
    }

    public User getById(UUID id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User with id: " + id + "not found");
        }
        return optionalUser.get();
    }

    public User save(User newUser) {
        User user = this.userRepository.save(newUser);
        return user;
    }


    public void delete(UUID id) throws NotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User with id: " + id + " not found");
        }

        User user = optionalUser.get();
        this.userRepository.delete(user);
    }
}
