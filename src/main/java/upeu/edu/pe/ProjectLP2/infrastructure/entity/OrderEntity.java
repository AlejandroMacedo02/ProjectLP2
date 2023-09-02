package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

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
    private LocalDateTime date;
    private String total;
    private String metodo_pago;
    private String direccion_envio;
    private String detalles_pago;
    private String notas;
    private Float descuentos;
    private String envio;

    public OrderEntity() {
        
    }

}
