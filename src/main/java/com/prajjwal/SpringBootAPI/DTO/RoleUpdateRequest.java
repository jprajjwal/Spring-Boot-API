package com.prajjwal.SpringBootAPI.DTO;

public class RoleUpdateRequest {

    private String role; // ROLE_USER / ROLE_ADMIN

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
