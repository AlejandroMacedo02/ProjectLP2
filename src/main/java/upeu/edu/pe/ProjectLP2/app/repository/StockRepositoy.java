/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.repository;

import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
public interface StockRepositoy {

    //LISTA DE TODOS LOS PRODUCTOS
    Iterable<StockEntity> getStocks();

    //LISTA DE PRODUCTOS POR USUARIO
    
    Iterable<StockEntity> getStocksByProduct(ProductEntity product);

    StockEntity getStockById(Integer id);

    StockEntity saveStock(StockEntity stock);

    void deleteStockById(Integer id);
}
