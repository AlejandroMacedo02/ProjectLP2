package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

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
    private String code;
    private Integer cantidadProducto;
    private BigDecimal precioUnitario;
    private BigDecimal total;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    public DetailOrderEntity() {
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

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
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
        return "DetailOrderEntity{" + "id=" + id + ", code=" + code + ", cantidadProducto=" + cantidadProducto + ", precioUnitario=" + precioUnitario + ", total=" + total + ", productEntity=" + productEntity + ", orderEntity=" + orderEntity + '}';
    }
    
    
}
