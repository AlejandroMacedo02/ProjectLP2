package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.UUID;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    private String code;
    private String description;
    private String entradas;
    private String salidas;
    private String balance;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public StockEntity() {
        this.setCode(UUID.randomUUID().toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntradas() {
        return entradas;
    }

    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    public String getSalidas() {
        return salidas;
    }

    public void setSalidas(String salidas) {
        this.salidas = salidas;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StockEntity{" + "id=" + id + ", code=" + code + ", description=" + description + ", entradas=" + entradas + ", salidas=" + salidas + ", balance=" + balance + ", productEntity=" + productEntity + '}';
    }
    

    

    
}
