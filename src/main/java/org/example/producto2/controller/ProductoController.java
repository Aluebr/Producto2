package org.example.producto2.controller;

import org.example.producto2.model.entity.Producto;
import org.example.producto2.model.services.ProductoDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {

    private final ProductoDAOImpl productoDAO;

    public ProductoController(ProductoDAOImpl productoDAO) {
        this.productoDAO = productoDAO;
    }

    @GetMapping("/productos")
    public String showProductos(Model model) {
        List<Producto> productos = productoDAO.findAll();
        model.addAttribute("productos", productos);
        return "productos";

    }
}
