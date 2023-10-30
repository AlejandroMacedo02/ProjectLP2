package upeu.edu.pe.ProjectLP2.infrastructure.controller;


import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.ProjectLP2.app.service.DetailOrderService;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;
import upeu.edu.pe.ProjectLP2.app.service.StockService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    
     private final Logger log = LoggerFactory.getLogger(HomeController.class);
    
    private final ProductService productService;
    private final StockService stockService;
    private final DetailOrderService detailOrderService;
    //private final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    
    // para almacenar los detalles de la orden
    List<DetailOrderEntity> detalles = new ArrayList<DetailOrderEntity>();

    // datos de la orden
    OrderEntity orden = new OrderEntity();

    public HomeController(ProductService productService, StockService stockService, DetailOrderService detailOrderService) {
        this.productService = productService;
        this.stockService = stockService;
        this.detailOrderService = detailOrderService;
    }

    

    @GetMapping
    public String home(Model model){
        
        
        model.addAttribute("products", productService.getProducts());
        return "home";
        
    }
    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model){
        List<StockEntity> stocks = stockService.getStocksByProduct(productService.getProductById(id));
        //log.info("Id product: {}", id);
        //log.info("stock size: {}", stocks.size());
        Integer lastBalance = stocks.get(stocks.size()-1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        try {
            model.addAttribute("id", 1);
        }catch (Exception e){

        }
        return "user/productdetail";
    } 
    
    
    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam(name = "quantity") Integer quantity, Model model, HttpSession session) {
        DetailOrderEntity detailOrder = new DetailOrderEntity();
        ProductEntity product = new ProductEntity();
        double sumaTotal = 0;

        Optional<ProductEntity> optionalProducto = productService.get(id);
        log.info("Producto añadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", quantity);
        product = optionalProducto.get();

        detailOrder.setCantidad(quantity);
        detailOrder.setPrecio(product.getPrice());
        detailOrder.setNombre(product.getName());
        detailOrder.setTotal(product.getPrice()* quantity);
        detailOrder.setProductEntity(product);

        //validar que le producto no se añada 2 veces
        Integer idProducto = product.getId();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getProductEntity().getId() == idProducto);

        if (!ingresado) {
            detalles.add(detailOrder);
        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        model.addAttribute("sesion", session.getAttribute("idusuario"));

        return "user/cart";
    } 
    
    /*@GetMapping("/cart/{id}")
    public String addcarrito(@PathVariable Integer id, Model model){
      ProductEntity pro = productService.getProductById(id);
      model.addAttribute("cart", pro);
     
       
        return "user/cart";
    }*/
    
}
