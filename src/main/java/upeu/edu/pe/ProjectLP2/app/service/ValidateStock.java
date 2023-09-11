package upeu.edu.pe.ProjectLP2.app.service;

import java.util.List;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
public class ValidateStock {

    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }
    private boolean existBalance(ProductEntity product){
        List<StockEntity> stockList = stockService.getStocksByProductEntity(product);
        return stockList.isEmpty() ? false:true;
    }
}
