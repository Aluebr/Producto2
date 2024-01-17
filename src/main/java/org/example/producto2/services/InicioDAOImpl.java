package org.example.producto2.services;

import jakarta.persistence.EntityManager;
import org.example.producto2.model.dao.InicioDAO;
import org.example.producto2.model.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InicioDAOImpl implements InicioDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Menu> getAllMenus() {
        return entityManager.createQuery("SELECT m FROM Menu m", Menu.class).getResultList();
    }

    @Override
    public void updateMenu(Menu menu) {
        /*Menu existingMenu = entityManager.find(Menu.class, menu.getIdMenu());
        if (existingMenu != null) {
            existingMenu.setPrecio(menu.getPrecio());
            existingMenu.setNombre(menu.getNombre());
            entityManager.merge(existingMenu);
        }*/
    }

    @Override
    public void deleteMenu(Long id) {
        // Usando JPA
        Menu menu = entityManager.find(Menu.class, id);
        if (menu != null) {
            entityManager.remove(menu);
        }
    }
}

