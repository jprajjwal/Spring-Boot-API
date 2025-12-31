package com.prajjwal.SpringBootAPI.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Welcome {

    @GetMapping("/")
    public String greet(Authentication authentication) {

        if (authentication == null) {
            return "Welcome Guest!!";
        }

        Object principal = authentication.getPrincipal();

        // OAuth2 Login
        if (principal instanceof org.springframework.security.oauth2.core.user.OAuth2User oauthUser) {
            String name = oauthUser.getAttribute("name");
            return "Welcome " + name + "!!";
        }

        // JWT Login
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails userDetails) {
            return "Welcome " + userDetails.getUsername() + "!!";
        }

        return "Welcome User!!";
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }
}
