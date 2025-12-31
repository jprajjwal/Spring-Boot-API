package com.prajjwal.SpringBootAPI.Controller;

import com.prajjwal.SpringBootAPI.DTO.RoleUpdateRequest;
import com.prajjwal.SpringBootAPI.Model.UserEntity;
import com.prajjwal.SpringBootAPI.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<String> changeRole(
            @PathVariable Long id,
            @RequestBody RoleUpdateRequest request) {

        userService.updateRole(id, request.getRole());
        return ResponseEntity.ok("Role updated successfully");
    }
}