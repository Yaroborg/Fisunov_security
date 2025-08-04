package com.fisunov_security.dao;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;

}
