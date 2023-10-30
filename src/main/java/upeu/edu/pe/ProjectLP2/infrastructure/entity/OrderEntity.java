package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Date;
/**
 *
 * @author alejandromacedop
 */
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public OrderEntity() {
        
    }

    public OrderEntity(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, double total, UserEntity userEntity, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
        this.userEntity = userEntity;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", numero=" + numero + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida=" + fechaRecibida + ", total=" + total + ", userEntity=" + userEntity + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + '}';
    }

    
}
