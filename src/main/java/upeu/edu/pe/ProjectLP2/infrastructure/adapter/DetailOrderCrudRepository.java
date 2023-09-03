package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;

/**
 *
 * @author alejandromacedop
 */
public interface DetailOrderCrudRepository extends CrudRepository<DetailOrderEntity, Integer>{
    
    Iterable<DetailOrderEntity> findByOrderEntity(OrderEntity orderEntity);
}
