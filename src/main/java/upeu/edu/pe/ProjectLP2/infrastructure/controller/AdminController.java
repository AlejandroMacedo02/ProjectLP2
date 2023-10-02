package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/home/admin")
public class AdminController {
    
    private final ProductService productService;
    // private final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public String home(Model model) {
        Iterable<ProductEntity> product = productService.getProducts();
        model.addAttribute("product", product);
        return "home/admin";
    }
}
