package org.angelalfaro.my_books.service;

import org.angelalfaro.my_books.entity.User;
import org.angelalfaro.my_books.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Business logic to save a new user
        return userRepository.save(user);
    }

    public User login(String username) {
        // Simple authentication logic without password encryption for this exercise
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElse(null);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}