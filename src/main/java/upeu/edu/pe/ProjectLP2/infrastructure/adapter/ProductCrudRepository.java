package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);

}
