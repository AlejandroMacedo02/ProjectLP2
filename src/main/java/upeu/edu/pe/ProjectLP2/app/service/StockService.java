/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.service;

import upeu.edu.pe.ProjectLP2.app.repository.StockRepositoy;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;



/**
 *
 * @author alejandromacedop
 */
public class StockService {
    
    private final StockRepositoy stockRepository;
    
    public StockService(StockRepositoy stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    public Iterable<StockEntity> getStocks() {
        return stockRepository.getStocks();
    }
    
    public Iterable<StockEntity> getStocksByProductEntity(ProductEntity productEntity) {
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
