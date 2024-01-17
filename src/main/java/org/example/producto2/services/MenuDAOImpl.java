package org.example.producto2.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.producto2.model.dao.MenuDAO;
import org.example.producto2.model.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuDAOImpl implements MenuDAO {

    private EntityManager entityManager;

    public MenuDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Menu findById(Long id) {
        return entityManager.find(Menu.class, id);
    }

    @Override
    public List<Menu> findAll() {
        return entityManager.createQuery("SELECT m FROM Menu m", Menu.class).getResultList();

    }

    @Override
    @Transactional
    public Menu save(Menu theMenu) {
        entityManager.persist(theMenu);
        return theMenu;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Menu menu = entityManager.find(Menu.class, id);
        if (menu != null) {
            entityManager.remove(menu);
        } else {
            System.out.println("No se encontró un nadador con el ID proporcionado: " + id);
        }
    }
}
