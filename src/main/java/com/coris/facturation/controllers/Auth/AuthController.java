package com.coris.facturation.controllers.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.coris.facturation.services.IUtilisateurService;

@Controller
public class AuthController {

    private IUtilisateurService userService;

    public AuthController(IUtilisateurService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
