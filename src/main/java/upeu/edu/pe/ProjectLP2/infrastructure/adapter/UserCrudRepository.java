/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public interface UserCrudRepository extends CrudRepository<UserEntity, Integer>{
    
       Optional<UserEntity> findByEmail(String email);

}
