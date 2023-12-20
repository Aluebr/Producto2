package org.example.producto2.model.services;

import org.example.producto2.model.dao.ProductoDAO;
import org.example.producto2.model.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public Producto findById(Long id) {
        return null;
    }

    @Override
    public List<Producto> findAll() {
        return null;
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

    @Override
    public void delete(Producto producto) {

    }
}
