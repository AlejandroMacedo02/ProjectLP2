/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.service.StockService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("admin/stocks")
public class StockController {
    
    private final StockService stockService;
    private final Logger log = LoggerFactory.getLogger(StockController.class);

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    
    // CREAR STOCK
    @GetMapping("/create")
    public String create(){
        return "admin/stocks/create";
    }
    
    // GUARDAR STOCK
    
    @PostMapping("/save-stocks")
    public String saveStock(StockEntity stock){
        log.info("Nombre de stock:{}", stock);
        stockService.saveStock(stock);
        return "admin/stocks/create";
    }
    
    // MOSTRAR STOCK
    
    @GetMapping("/show")
    public String showStock(Model model){
        ProductEntity product = new ProductEntity();
        product.setId(1);
        Iterable<StockEntity> stocks = stockService.getStocksByProduct(product);
        model.addAttribute("stocks", stocks);
        return "admin/stocks/show";
    }
    
    // EDITAR STOCK
    
    @GetMapping("/edit/{id}")
    public String editStock(@PathVariable Integer product, Model model){
        StockEntity stock = stockService.getStocksByProduct(product);
        log.info("Stock obtenido: {}", stock);
        model.addAttribute("stock", stock);
        return "admin/stocks/edit";
    }
    
    // ELIMINAR STOCK
    
    @GetMapping("/delete/{id}")
    public String deleteStock(@PathVariable Integer id){
        stockService.deleteStockById(id);
        return "redirect:/admin/stocks/show";
    }
}
