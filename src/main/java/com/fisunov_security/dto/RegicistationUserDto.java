package com.fisunov_security.dto;
import com.fisunov_security.entity.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
public class RegicistationUserDto {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;


}
