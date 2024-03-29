package org.example.producto2.model.dao;

import org.example.producto2.model.entity.Menu;

import java.util.List;

public interface MenuDAO {
    Menu findById(Long id);

    List<Menu> findAll();

    Menu save(Menu menu);

    void delete(Long id);

}
