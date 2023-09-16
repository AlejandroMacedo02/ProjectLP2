package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.Entity;
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
@Table (name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    
}
