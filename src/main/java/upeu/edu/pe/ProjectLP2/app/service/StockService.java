
package upeu.edu.pe.ProjectLP2.app.service;

import java.util.List;
import org.slf4j.*;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;
import upeu.edu.pe.ProjectLP2.app.repository.StockRepository;



/**
 *
 * @author alejandromacedop
 */
public class StockService {
    
    private final StockRepository stockRepository;
    
    private final Logger log = LoggerFactory.getLogger(StockService.class);

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    public Iterable<StockEntity> getStocks() {
        return stockRepository.getStocks();
    }
    
    public List<StockEntity> getStocksByProduct(ProductEntity productEntity) {
        return stockRepository.getStockByProductEntity(productEntity);
    }
    
    public StockEntity getStockById(Integer id) {
        return stockRepository.getStockById(id);
    }
    
    public StockEntity saveStock(StockEntity stock) {
        if (stock.getId() == null) {
            ProductEntity product = new ProductEntity();
            product.setId(1);
            stock.setProductEntity(product);
            
            stock.setEntradas(Integer.BYTES);
            stock.setSalidas(Integer.SIZE);
        return stockRepository.saveStock(stock);
    }else{
         StockEntity stockDB = stockRepository.getStockById(stock.getId());
                 log.info("product: {}",stockDB);
         //sino se carga la imagen toma la que se le guardo al registro
         stock.setProductEntity(stockDB.getProductEntity());
         stock.setDescription(stockDB.getDescription());
         stock.setEntradas(stockDB.getEntradas());
         stock.setSalidas(stockDB.getSalidas());
         
        return stockRepository.saveStock(stock);
    }
    }
    
    public void deleteStockById(Integer id) {
        stockRepository.deleteStockById(id);
    }
    
    
}

