package csd.backend.Admin.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import csd.backend.Admin.Admin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can be defined here if needed, like finding users by username.
    User findByUsername(String username);
}
