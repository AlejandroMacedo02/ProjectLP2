package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public interface OrderCrudRepositoy extends CrudRepository<OrderEntity, Integer>  {
    
    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);
}
