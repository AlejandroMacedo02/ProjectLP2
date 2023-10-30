package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author alejandromacedop
 */
@Entity
@Table(name = "detalleordenes")
public class DetailOrderEntity {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    public DetailOrderEntity() {
    }

    public DetailOrderEntity(Integer id, String nombre, double cantidad, double precio, double total, ProductEntity productEntity, OrderEntity orderEntity) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.productEntity = productEntity;
        this.orderEntity = orderEntity;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public String toString() {
        return "DetailOrderEntity{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + ", productEntity=" + productEntity + ", orderEntity=" + orderEntity + '}';
    }

    
    
    
}
