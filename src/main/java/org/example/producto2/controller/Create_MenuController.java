package org.example.producto2.controller;


import org.example.producto2.model.entity.Menu;
import org.example.producto2.model.services.CreateMenuDAOImpl;
import org.example.producto2.model.services.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Create_MenuController {
    private final CreateMenuDAOImpl menuDAO;
    private final ProductoDAOImpl productoDAO;

    @Autowired
    public Create_MenuController(CreateMenuDAOImpl menuDAO, ProductoDAOImpl productoDAO) {
        this.menuDAO = menuDAO;
        this.productoDAO = productoDAO;
    }

    @GetMapping("/menu/new")
    public String showForm(Model model) {

        model.addAttribute("menu", new Menu());
        return "Create_menu";

    }

    @PostMapping("/menu")
    public String saveMenu(Menu menu) {
        menuDAO.save(menu);
        return "redirect:/menu/new";
    }
}
