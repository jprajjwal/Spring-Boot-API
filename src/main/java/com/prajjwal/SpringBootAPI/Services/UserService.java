package com.prajjwal.SpringBootAPI.Services;

import com.prajjwal.SpringBootAPI.Model.UserEntity;
import com.prajjwal.SpringBootAPI.Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo repo;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, PasswordEncoder passwordEncoder){
        this.repo=repo;
        this.passwordEncoder=passwordEncoder;
    }
    public UserEntity register(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }

    public void updateRole(Long id, String role) {
        UserEntity user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Safety check
        if (!role.equals("ROLE_USER") && !role.equals("ROLE_ADMIN")) {
            throw new IllegalArgumentException("Invalid role");
        }
        user.setRole(role);
        repo.save(user);
    }
}
