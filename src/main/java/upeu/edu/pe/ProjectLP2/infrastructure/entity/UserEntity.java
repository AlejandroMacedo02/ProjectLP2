package upeu.edu.pe.ProjectLP2.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alejandromacedop
 */
//getter And setter
@Data
//constructor lleno
@AllArgsConstructor
//consytuctor vacio
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String firtName;
  private String lastName;
  private String email;
  private String address;
  private String cellphone;
  private String password;
  @Enumerated(EnumType.STRING)
  private UserType userType;
  
  private LocalDateTime dateCreated;


  
  
}
