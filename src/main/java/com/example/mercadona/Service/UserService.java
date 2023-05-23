package com.example.mercadona.Service;

import com.example.mercadona.Repository.UserRepository;
import com.example.mercadona.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById((long) id);
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
