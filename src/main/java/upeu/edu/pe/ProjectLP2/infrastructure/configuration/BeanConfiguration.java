package upeu.edu.pe.ProjectLP2.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.ProjectLP2.app.repository.DetailOrderRepository;
import upeu.edu.pe.ProjectLP2.app.repository.OrderRepository;
import upeu.edu.pe.ProjectLP2.app.repository.ProductRepository;
import upeu.edu.pe.ProjectLP2.app.service.DetailOrderService;
import upeu.edu.pe.ProjectLP2.app.service.OrderService;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;
import upeu.edu.pe.ProjectLP2.app.service.StockService;
import upeu.edu.pe.ProjectLP2.app.service.UploadFile;
import upeu.edu.pe.ProjectLP2.app.repository.StockRepository;
import upeu.edu.pe.ProjectLP2.app.repository.UserRepository;
import upeu.edu.pe.ProjectLP2.app.service.UserService;

/**
 *
 * @author alejandromacedop
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);

    }
    
    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);

    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderService(orderRepository);

    }

    @Bean
    public DetailOrderService detailOrderService(DetailOrderRepository detailOrderRepository) {
        return new DetailOrderService(detailOrderRepository);
    }
    
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
    
    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

}
