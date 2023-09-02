/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.pe.ProjectLP2.app.service.StockService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
@RestController
@RequestMapping("/api/v1/stock/")
public class StockControllerApi {

    private final StockService stockService;

    public StockControllerApi(StockService stockService) {
        this.stockService = stockService;
    }

    //crear stock 
    @PostMapping("/save-stock")
    public String saveStock(@RequestBody StockEntity stockEntity) {
        return stockService.saveStock(stockEntity).toString();
    }

    //ver stock
    @GetMapping("/show")
    public Iterable<StockEntity> showStock() {
        ProductEntity product = new ProductEntity();
        product.setId(1);
        return stockService.getStocksByProductEntity(product);
    }

    //buscar stock por ID
    @GetMapping("/show/{id}")
    public StockEntity show(@PathVariable Integer id){
        return stockService.getStockById(id);
    }
    
    //editar un product
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public StockEntity editStock(@RequestBody StockEntity stock, @PathVariable Integer id){
        StockEntity stockActual = stockService.getStockById(id);
        stockActual.setDescription(stock.getDescription());
        stockActual.setBalance(stock.getBalance());
        stockActual.setSalidas(stock.getSalidas());
        stockActual.setEntradas(stock.getEntradas());
        stockActual.setProductEntity(stock.getProductEntity());
        return stockService.saveStock(stockActual);
    }
    
    //eliminar un product
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStock(@PathVariable Integer id){
        stockService.deleteStockById(id);
    }
}
