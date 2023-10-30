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

    private boolean existBalance(ProductEntity product) {
        List<StockEntity> stockList = stockService.getStocksByProduct(product);
        return stockList.isEmpty() ? false : true;
    }

    public StockEntity calculateBalance(StockEntity stock) {

        if (stock.getEntradas() != 0) {
            if (existBalance(stock.getProductEntity())) {
                List<StockEntity> stockList = stockService.getStocksByProduct(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size() - 1).getBalance();
                stock.setBalance(balance + stock.getEntradas());
                
            } else {
                stock.setBalance(stock.getEntradas());
            }

        } else {
            List<StockEntity> stockList = stockService.getStocksByProduct(stock.getProductEntity());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance - stock.getSalidas());
        }
        return stock;
    }
}
