package com.undec.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private Collection<Detalle> detallesById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio")
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) &&
                Objects.equals(nombre, producto.nombre) &&
                Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "productoByProductoId")
    public Collection<Detalle> getDetallesById() {
        return detallesById;
    }

    public void setDetallesById(Collection<Detalle> detallesById) {
        this.detallesById = detallesById;
    }
}
