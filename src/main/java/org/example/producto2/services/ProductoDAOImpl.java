package org.example.producto2.services;

import jakarta.persistence.EntityManager;
import org.example.producto2.model.dao.ProductoDAO;
import org.example.producto2.model.entity.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDAOImpl implements ProductoDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Producto findById(Long id) {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public List<Producto> findAll() {
        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

    @Override
    public void delete(Producto producto) {

    }
}
