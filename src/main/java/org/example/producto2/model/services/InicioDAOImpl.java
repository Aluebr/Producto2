package org.example.producto2.model.services;

import org.example.producto2.model.dao.InicioDAO;
import org.example.producto2.model.entity.Menu;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class InicioDAOImpl implements InicioDAO {


    @Override
    public void createMenu(Menu menu) {

    }

    @Override
    public Menu getMenuById(Long id) {
        return null;
    }

    @Override
    public List<Menu> getAllMenus() {
        return null;
    }

    @Override
    public void updateMenu(Menu menu) {

    }

    @Override
    public void deleteMenu(Long id) {

    }

    // Other CRUD methods implemented here
}
