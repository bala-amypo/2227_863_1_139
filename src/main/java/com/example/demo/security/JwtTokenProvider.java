package com.example.demo.security;

import java.util.Base64;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {

        String payload =
                userId + "|" +
                email + "|" +
                String.join(",", roles);

        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return Long.parseLong(decoded.split("\\|")[0]);
    }

    public String getEmail(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[1];
    }

    public Set<String> getRoles(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        String[] roles = decoded.split("\\|")[2].split(",");
        return new HashSet<>(Arrays.asList(roles));
    }
}