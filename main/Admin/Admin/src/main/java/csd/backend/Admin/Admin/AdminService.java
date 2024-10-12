package csd.backend.Admin.Admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import csd.backend.Admin.Admin.model.User;
import csd.backend.Admin.Admin.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(String username, String password, Boolean isAdmin) {
        // You can add validation here, like checking if the user already exists
        User newUser = new User(username, password, isAdmin);
        return userRepository.save(newUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
