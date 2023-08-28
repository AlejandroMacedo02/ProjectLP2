/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author alejandromacedop
 */
@Entity
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String estado;
    private String imagen;
    private LocalDateTime fecha_ingreso;
    private LocalDateTime fecha_vencimiento;
    private LocalDateTime fecha_actualizacion;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity ProductEntity;

    public StockEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDateTime getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalDateTime getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDateTime fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public LocalDateTime getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public ProductEntity getProductEntity() {
        return ProductEntity;
    }

    public void setProductEntity(ProductEntity ProductEntity) {
        this.ProductEntity = ProductEntity;
    }
    
    

    @Override
    public String toString() {
        return "StockEntity{" + "id=" + id + ", estado=" + estado + ", imagen=" + imagen + ", fecha_ingreso=" + fecha_ingreso + ", fecha_vencimiento=" + fecha_vencimiento + ", fecha_actualizacion=" + fecha_actualizacion + ", ProductEntity=" + ProductEntity + '}';
    }

    

}
