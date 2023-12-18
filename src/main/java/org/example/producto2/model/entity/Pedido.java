package org.example.producto2.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "numero", nullable = false, length = 45, unique = true)
    private String numero;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    private Usuario usuario;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}