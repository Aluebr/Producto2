package org.example.producto2.model.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.producto2.model.dao.Create_MenuDAO;
import org.example.producto2.model.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreateMenuDAOImpl implements Create_MenuDAO {

    private EntityManager entityManager;

    public CreateMenuDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Menu findById(Long id) {
        return null;
    }

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Menu save(Menu theMenu) {
        entityManager.persist(theMenu);
        return theMenu;
    }

    @Override
    public void delete(Menu menu) {

    }


}
