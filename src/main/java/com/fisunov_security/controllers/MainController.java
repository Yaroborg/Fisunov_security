package com.fisunov_security.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/unsecured")
    public String unsecuredData() {
        return "This is an unsecured endpoint";
    }

    @GetMapping("/secured")
    public String securedData() {
        return "This is an secured endpoint";
    }

    @GetMapping("/admin")
    public String adminData() {
        return "This is an admin endpoint";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }


}
