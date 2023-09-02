/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.ProjectLP2.app.repository.OrderRepository;
import upeu.edu.pe.ProjectLP2.app.repository.ProductRepository;
import upeu.edu.pe.ProjectLP2.app.repository.StockRepositoy;
import upeu.edu.pe.ProjectLP2.app.service.OrderService;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;
import upeu.edu.pe.ProjectLP2.app.service.StockService;

/**
 *
 * @author alejandromacedop
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);

    }

    @Bean
    public StockService stockService(StockRepositoy stockRepository) {
        return new StockService(stockRepository);

    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderService(orderRepository);

    }
}
