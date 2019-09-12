package com.undec.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private Collection<Factura> facturasById;

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
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) &&
                Objects.equals(nombre, cliente.nombre) &&
                Objects.equals(apellido, cliente.apellido) &&
                Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, email);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "clienteByClienteId")
    public Collection<Factura> getFacturasById() {
        return facturasById;
    }

    public void setFacturasById(Collection<Factura> facturasById) {
        this.facturasById = facturasById;
    }
}
