package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;
import upeu.edu.pe.ProjectLP2.app.repository.StockRepository;
/**
 *
 * @author alejandromacedop
 */
@Repository
public class StockRepositoryImpl implements StockRepository {

    private final StockCrudRepository stockCrudRepository;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public Iterable<StockEntity> getStocks() {
        return stockCrudRepository.findAll();
    }

    @Override
    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity) {
        return stockCrudRepository.findStockByProductEntity(productEntity);
    
    }
    @Override
    public StockEntity getStockById(Integer id) {
        return stockCrudRepository.findById(id).get();
    }

    @Override
    public StockEntity saveStock(StockEntity stock) {
        return stockCrudRepository.save(stock);
    }

    @Override
    public void deleteStockById(Integer id) {
        stockCrudRepository.deleteById(id);
    }

}
