
package upeu.edu.pe.ProjectLP2.app.service;

import java.util.List;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;
import upeu.edu.pe.ProjectLP2.app.repository.StockRepository;



/**
 *
 * @author alejandromacedop
 */
public class StockService {
    
    private final StockRepository stockRepository;
    
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    public Iterable<StockEntity> getStocks() {
        return stockRepository.getStocks();
    }
    
    public List<StockEntity> getStocksByProductEntity(ProductEntity productEntity) {
        return stockRepository.getStockByProductEntity(productEntity);
    }
    
    public StockEntity getStockById(Integer id) {
        return stockRepository.getStockById(id);
    }
    
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }
    
    public void deleteStockById(Integer id) {
        stockRepository.deleteStockById(id);
    }
    
}
