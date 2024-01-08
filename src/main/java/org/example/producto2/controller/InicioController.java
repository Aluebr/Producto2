package org.example.producto2.controller;

import org.example.producto2.model.dao.InicioDAO;
import org.example.producto2.model.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InicioController {

    @Autowired
    private InicioDAO inicioDAO;

    @GetMapping("/lista/new")
    public String showCreateMenu(Model model) {
        model.addAttribute("menu", new Menu());
        return "inicio";
    }

    /*@PostMapping("/lista")
    public String createMenu(@ModelAttribute Menu menu) {
        inicioDAO.createMenu(menu);
        return "redirect:/lista/new";
    }*/

    // Additional controller methods for read, update, and delete
}
