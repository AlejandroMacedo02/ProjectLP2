package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private String code;
    private String desciption;
    private String total;
    private String metodo_pago;
    private String direccion_envio;
    private String detalles_pago;
    private String envio;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public OrderEntity() {
        this.setCode(UUID.randomUUID().toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public String getDetalles_pago() {
        return detalles_pago;
    }

    public void setDetalles_pago(String detalles_pago) {
        this.detalles_pago = detalles_pago;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
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
        return "OrderEntity{" + "id=" + id + ", code=" + code + ", desciption=" + desciption + ", total=" + total + ", metodo_pago=" + metodo_pago + ", direccion_envio=" + direccion_envio + ", detalles_pago=" + detalles_pago + ", envio=" + envio + ", userEntity=" + userEntity + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + '}';
    }

}
