/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

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
    private Integer cantidad_producto;
    private BigDecimal precio_unitario;
    private BigDecimal total;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;  

    public DetailOrderEntity() {
    }
    
}
