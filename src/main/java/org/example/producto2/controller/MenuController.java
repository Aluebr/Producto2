package org.example.producto2.controller;


import jakarta.transaction.Transactional;
import org.example.producto2.model.entity.Menu;
import org.example.producto2.model.entity.Producto;
import org.example.producto2.services.MenuDAOImpl;
import org.example.producto2.services.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class MenuController {
    private final MenuDAOImpl menuDAO;
    private final ProductoDAOImpl productoDAO;
    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    public MenuController(MenuDAOImpl menuDAO, ProductoDAOImpl productoDAO) {
        this.menuDAO = menuDAO;
        this.productoDAO = productoDAO;
    }

    @GetMapping("/menus")
    public String showMenus(Model model) {
        List<Menu> menus = menuDAO.findAll();
        model.addAttribute("menus", menus);
        return "menus";

    }

    @GetMapping("/menus/edit")
    public String getMenuDetail(@RequestParam("menuId") Long menuId,Model model) {
        Menu menu = menuDAO.findById(menuId);
        Menu newMenu = new Menu();
        newMenu.setNombre(menu.getNombre());
        newMenu.setPrecio(menu.getPrecio());

        List<Producto> productList = productoDAO.findAll();
        model.addAttribute("menu", newMenu);
        model.addAttribute("productos", productList);
        return "editMenu";
    }

    @GetMapping("/menus/new")
    public String showForm(Model model) {
        Menu newMenu = new Menu();
        newMenu.setNombre("Menú Ejemplo");
        newMenu.setPrecio(10.0f);


        List<Producto> productList = productoDAO.findAll();
        model.addAttribute("menu", newMenu);
        model.addAttribute("productos", productList);
        return "newMenu";

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
            model.addAttribute("success", true);

            menuDAO.save(menu);

        } else {
            logger.info("No se seleccionaron productos");
            model.addAttribute("error", "No se seleccionaron productos");
            model.addAttribute("menu", menu);
            model.addAttribute("productos", productoDAO.findAll());
        }
        return "newMenu";
    }

    @GetMapping("/menus/delete")
    public String deleteMenu(@RequestParam("menuId") Long menuId) {
        menuDAO.delete(menuId);
        return "redirect:/menus";
    }

    @PostMapping("/menu/update")
    public String updateMenu(@ModelAttribute("menu") Menu menu) {
        menuDAO.update(menu);
        return "redirect:/menus";
    }

}
