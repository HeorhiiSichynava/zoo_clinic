package com.hs.zoo_clinic.zoo_clinic.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthResponse {
    String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
