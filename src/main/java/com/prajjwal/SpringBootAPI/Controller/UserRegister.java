package com.prajjwal.SpringBootAPI.Controller;

import com.prajjwal.SpringBootAPI.Model.UserEntity;
import com.prajjwal.SpringBootAPI.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class UserRegister {

    private UserService service;
    public UserRegister(UserService service){
        this .service=service;
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user){
        return service.register(user);
    }
}
