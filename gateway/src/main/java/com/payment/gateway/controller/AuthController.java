package com.payment.gateway.controller;

import com.payment.gateway.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // this will check whether username and password comming in request  are present in database or not
    private final Map<String, String> users = Map.of(
            "amol", "password123",
            "admin", "admin123"
    );

    // this will check role of user comming in request
    private final Map<String, List<String>> roles = Map.of(
            "amol", List.of("USER"),
            "admin", List.of("ADMIN")
    );

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            String token = JwtUtil.generateToken(username, roles.get(username));
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}
