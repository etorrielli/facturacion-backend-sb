package com.undec.facturacion.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Factura {
    private Integer id;
    private Integer folio;
    private String descripcion;
    private String observacion;
    private Date fecha;
    private Collection<Detalle> detallesById;
    private Cliente clienteByClienteId;

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
    @Column(name = "folio")
    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(id, factura.id) &&
                Objects.equals(folio, factura.folio) &&
                Objects.equals(descripcion, factura.descripcion) &&
                Objects.equals(observacion, factura.observacion) &&
                Objects.equals(fecha, factura.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, folio, descripcion, observacion, fecha);
    }

    @OneToMany(mappedBy = "facturaByFacturaId")
    public Collection<Detalle> getDetallesById() {
        return detallesById;
    }

    public void setDetallesById(Collection<Detalle> detallesById) {
        this.detallesById = detallesById;
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    public Cliente getClienteByClienteId() {
        return clienteByClienteId;
    }

    public void setClienteByClienteId(Cliente clienteByClienteId) {
        this.clienteByClienteId = clienteByClienteId;
    }
}
