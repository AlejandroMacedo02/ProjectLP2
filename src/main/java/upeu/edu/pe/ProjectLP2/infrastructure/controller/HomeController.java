package upeu.edu.pe.ProjectLP2.infrastructure.controller;


import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    
    private final ProductService productService;
    private final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    
    public HomeController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public String home(Model model){
        
        model.addAttribute("products", productService.getProducts());
        LOG.info("product {}", productService.getProducts());
        return "home";
    }
}
