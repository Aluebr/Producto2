package org.example.producto2.model.dao;

import org.example.producto2.model.entity.Menu;

import java.util.List;

public interface InicioDAO {
    List<Menu> getAllMenus();
    void updateMenu(Menu menu);
    void deleteMenu(Long id);
}
