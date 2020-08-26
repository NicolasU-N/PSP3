package com.project.Contabilidad.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "Precio mínimo 0 pesos")
    @NotNull
    private double precio;

    @Min(value = 0, message = "Cantidad mínimo 0")
    @NotNull
    private double cantidad;

    @NotNull
    private String descripcion;

    private boolean state;

    private Date createAt;

    private Date updateAt;

    public Producto() {

    }

    public Producto(double precio, double cantidad, String descripcion) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @PrePersist
    public void init() {
        Date date = new Date();

        this.createAt = date;
        this.updateAt = date;
        this.state = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", descripcion=" + descripcion +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
