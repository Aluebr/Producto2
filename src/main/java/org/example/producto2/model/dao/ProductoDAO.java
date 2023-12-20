package org.example.producto2.model.dao;

import org.example.producto2.model.entity.Menu;
import org.example.producto2.model.entity.Producto;

import java.util.List;

public interface ProductoDAO {

    Producto findById(Long id);

    List<Producto> findAll();

    Producto save(Producto producto);

    void delete(Producto producto);



}
