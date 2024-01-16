package org.example.producto2.controller.security;

import org.example.producto2.model.entity.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
    public class LoginController {
        @GetMapping("/login")
        public String showMyLoginPage() {
            return "login";
        }

    /*@GetMapping("/login")
    public String showLogin() {
        return "login";

    }*/

}
