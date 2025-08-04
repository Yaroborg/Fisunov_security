package com.fisunov_security.controllers;
import com.fisunov_security.dto.JwtRequest;
import com.fisunov_security.dto.JwtResponce;
import com.fisunov_security.exception.Apperror;
import com.fisunov_security.service.UserService;
import com.fisunov_security.utills.JwtTokenUtills;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenUtills jwtTokenUtills;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(), authRequest.getPassword()
            ));
        } catch (BadCredentialsException e) {
           return new ResponseEntity<>( new Apperror("Incorrect username or password", HttpStatus.UNAUTHORIZED.value()),
                    HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtills.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponce(token));
    }
}
