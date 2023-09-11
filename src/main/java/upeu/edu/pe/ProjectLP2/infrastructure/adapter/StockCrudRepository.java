package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    List <StockEntity> findStockByProductEntity(ProductEntity productEntity);
}
