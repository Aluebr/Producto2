package org.example.producto2.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @ManyToMany
    @JoinTable(
            name = "menu_has_usuario",
            joinColumns = @JoinColumn(name = "menu_id_menu"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id_usuario")
    )
    private Set<Usuario> usuarios;

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @ManyToMany
    @JoinTable(
            name = "menu_has_producto",
            joinColumns = @JoinColumn(name = "menu_id_menu"),
            inverseJoinColumns = @JoinColumn(name = "producto_id_producto")
    )
    private Set<Producto> productos;

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

