package csd.backend.Admin.Admin;

// import org.hibernate.mapping.List;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import csd.backend.Admin.Admin.User;
import csd.backend.Admin.Admin.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint to add a new user
    // @PostMapping("/users")
    // public ResponseEntity<User> addUser(@RequestParam String username,
    // @RequestParam String password,
    // @RequestParam Boolean isAdmin) {
    // User newUser = adminService.addUser(username, password, isAdmin);
    // return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    // }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')") // Only allow admins to access
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminService.getAllUsers(); 
        return ResponseEntity.ok(users);
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = adminService.addUser(user.getUsername(), user.getPassword(), user.getIsAdmin());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Endpoint to delete a user
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        adminService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // @GetMapping("/users")
    // @PreAuthorize("hasRole('ADMIN')") // Only allow admins to access
    // public ResponseEntity<List<User>> getAllUsers() {
    //     List<User> users = adminService.getAllUsers(); 
    //     return ResponseEntity.ok(users);
    // }

    //use after integration
    // @GetMapping("/users")
    // public ResponseEntity<List<User>> getAllUsers() {
    //     if (!isAdmin()) {
    //         return new ResponseEntity<>(HttpStatus.FORBIDDEN); // Return 403 Forbidden if not admin
    //     }

    //     List<User> users = adminService.getAllUsers();
    //     return ResponseEntity.ok(users);
    // }
}
