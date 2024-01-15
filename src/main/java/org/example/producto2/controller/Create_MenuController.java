package org.example.producto2.controller;


import org.example.producto2.model.entity.Menu;
import org.example.producto2.model.entity.Producto;
import org.example.producto2.model.services.CreateMenuDAOImpl;
import org.example.producto2.model.services.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class Create_MenuController {
    private final CreateMenuDAOImpl menuDAO;
    private final ProductoDAOImpl productoDAO;
    private static Logger logger = LoggerFactory.getLogger(Create_MenuController.class);

    @Autowired
    public Create_MenuController(CreateMenuDAOImpl menuDAO, ProductoDAOImpl productoDAO) {
        this.menuDAO = menuDAO;
        this.productoDAO = productoDAO;
    }

    @GetMapping("/menus")
    public String showMenus(Model model) {
        List<Menu> menus = menuDAO.findAll();
        model.addAttribute("menus", menus);
        return "menus";

    }

    @GetMapping("/menus/new")
    public String showForm(Model model) {
        Menu newMenu = new Menu();
        newMenu.setNombre("Menú Ejemplo");
        newMenu.setPrecio(10.0f);


        List<Producto> productList = productoDAO.findAll();
        model.addAttribute("menu", newMenu);
        model.addAttribute("productos", productList);
        return "Create_menu";

    }

    @PostMapping("/menu")
    public String saveMenu(@ModelAttribute Menu menu, @RequestParam(required = false) List<Long> productosID,Model model) {
        if (productosID != null && !productosID.isEmpty()) {
            logger.info(productosID.toString());
            Set<Producto> productosSeleccionados = productosID.stream()
                    .map(id -> productoDAO.findById(id))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());
            menu.setProductos(productosSeleccionados);
            menuDAO.save(menu);
            return "redirect:/menu/new";
        } else {
            logger.info("No se seleccionaron productos");
            model.addAttribute("error", "No se seleccionaron productos");
            model.addAttribute("menu", menu);
            model.addAttribute("productos", productoDAO.findAll());
        }
        return "Create_menu";
    }





}
