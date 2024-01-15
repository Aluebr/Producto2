package org.example.producto2.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class LoginController {
        @GetMapping("/MyLoginPage")
        public String showMyLoginPage() {
            return "login";
        }

}
