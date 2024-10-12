package csd.backend.Admin.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import csd.backend.Admin.Admin.User;
import csd.backend.Admin.Admin.UserRepository;
import java.util.*;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Fetch all users from the database
    }

    public User addUser(String username, String password, Boolean isAdmin) {
        // You can add validation here, like checking if the user already exists
        User newUser = new User(username, password, isAdmin);
        return userRepository.save(newUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
