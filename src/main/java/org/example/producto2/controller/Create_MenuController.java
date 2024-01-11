package org.example.producto2.controller;


import org.example.producto2.model.entity.Menu;
import org.example.producto2.model.entity.Producto;
import org.example.producto2.model.services.CreateMenuDAOImpl;
import org.example.producto2.model.services.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Menu newMenu = new Menu();
        newMenu.setNombre("Menú Ejemplo");
        newMenu.setPrecio(10.0f);

        //menuDAO.save(newMenu);
        List<Producto> productList = productoDAO.findAll();
        model.addAttribute("menu", newMenu);
        model.addAttribute("productos", productList);
        return "Create_menu";

    }

    @PostMapping("/menu")
    public String saveMenu(Menu menu, @RequestParam("productoIds") List<Long> productoIds) {
        Set<Producto> productosSeleccionados = new HashSet<>();

        for (Long productoId : productoIds) {
            Producto producto = productoDAO.findById(productoId);
            if (producto != null) {
                productosSeleccionados.add(producto);
                producto.getMenus().add(menu); // Si es necesario mantener la relación bidireccional
            }
        }

        menu.setProductos(productosSeleccionados);
        menuDAO.save(menu);

        return "redirect:/menu/new";
    }

    /*@GetMapping("/menu/new")
    public String showForm(Model model) {
        Menu newMenu = new Menu();
        Set<Producto> productos = new HashSet<>(productoDAO.findAll());
        newMenu.setProductos(productos);
        model.addAttribute("menu", newMenu);
        return "Create_menu";
    }*/

}
