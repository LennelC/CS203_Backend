package csd.backend.Admin.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import csd.backend.Admin.Admin.model.User;
import csd.backend.Admin.Admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint to add a new user
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestParam String username, 
                                        @RequestParam String password, 
                                        @RequestParam Boolean isAdmin) {
        User newUser = adminService.addUser(username, password, isAdmin);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Endpoint to delete a user
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        adminService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
