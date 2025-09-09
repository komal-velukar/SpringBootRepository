package com.soft.service;

import com.soft.model.User;
import com.soft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update an existing user
    public User updateUser(Long id, User userDetails) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());

        return userRepository.save(existingUser);
    }

    // Delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}



