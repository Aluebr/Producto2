package org.example.producto2.controller;


import org.example.producto2.model.dao.MenuDAO;
import org.example.producto2.model.entity.Menu;
import org.example.producto2.model.entity.Producto;
import org.example.producto2.model.entity.Tipo;
import org.example.producto2.model.services.MenuDAOImpl;
import org.example.producto2.model.services.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class MenuController {
    private final MenuDAOImpl menuDAO;
    private final ProductoDAOImpl productoDAO;

    @Autowired
    public MenuController(MenuDAOImpl menuDAO, ProductoDAOImpl productoDAO) {
        this.menuDAO = menuDAO;
        this.productoDAO = productoDAO;
    }

    @GetMapping("/menu/new")
    public String showForm(Model model) {

        model.addAttribute("menu", new Menu());
        return "menu";

    }

    @PostMapping("/menu")
    public String saveMenu(Menu menu) {
        menuDAO.save(menu);
        return "redirect:/menu/new"; // o redirigir a donde prefieras después de guardar
    }
}
