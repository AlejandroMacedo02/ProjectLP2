/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ProjectLP2.app.repository.StockRepositoy;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;
/**
 *
 * @author alejandromacedop
 */
@Repository
public class StockRepositoryImpl implements StockRepositoy {

    private final StockCrudRepository stockCrudRepository;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public Iterable<StockEntity> getStocks() {
        return stockCrudRepository.findAll();
    }

    @Override
    public Iterable<StockEntity> getStocksByProduct(ProductEntity product) {
        return stockCrudRepository.findByUserEntity(product);
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
