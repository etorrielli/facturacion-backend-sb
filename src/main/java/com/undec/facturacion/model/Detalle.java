package com.undec.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Detalle {
    private Integer id;
    private Integer cantidad;
    private Producto productoByProductoId;
    private Factura facturaByFacturaId;

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
    @Column(name = "cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle detalle = (Detalle) o;
        return Objects.equals(id, detalle.id) &&
                Objects.equals(cantidad, detalle.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad);
    }

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false)
    public Producto getProductoByProductoId() {
        return productoByProductoId;
    }

    public void setProductoByProductoId(Producto productoByProductoId) {
        this.productoByProductoId = productoByProductoId;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Factura getFacturaByFacturaId() {
        return facturaByFacturaId;
    }

    public void setFacturaByFacturaId(Factura facturaByFacturaId) {
        this.facturaByFacturaId = facturaByFacturaId;
    }
}
