package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User registerUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmailIgnoreCase(email).orElseThrow(()->new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new ValidationException("Invalid password");
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }
}
