package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.repository.UserRepository;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;
import upeu.edu.pe.ProjectLP2.app.service.StockService;
import upeu.edu.pe.ProjectLP2.app.service.UserService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.StockEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserType;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final StockService stockService;

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    public AdminController(ProductService productService, UserService userService, UserRepository userRepository, StockService stockService) {
        this.productService = productService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.stockService = stockService;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "/admin/dashboard";
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "admin/home_admin";

    }

    @GetMapping("inventario/{id}")
    public String inventario(@PathVariable Integer id, Model model) {
        ProductEntity product = new ProductEntity();
        product.setId(id);
        List<StockEntity> stocks = stockService.getStocksByProduct(product);
        model.addAttribute("stocks", stocks);
        model.addAttribute("idproduct", id);
        return "admin/products/inventario";
    }

    @GetMapping("/editinv/{id}")
    public String editinv(@PathVariable Integer id, Model model) {
        List<StockEntity> stocks = stockService.getStocksByProduct(productService.getProductById(id));
        //log.info("Id product: {}", id);
        //log.info("stock size: {}", stocks.size());
        Integer lastBalance = stocks.get(stocks.size() - 1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        try {
            model.addAttribute("id", 1);
        } catch (Exception e) {

        }
        return "admin/products/editinv";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    // /usuario/registro
    @GetMapping("/registro")
    public String create() {
        return "admin/registro";
    }

    @PostMapping("/save")
    public String save(UserEntity usuario) {
        log.info("Usuario registro: {}", usuario);

        usuario.setUserType(UserType.ADMIN);
        userRepository.save(usuario);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "admin/login";
    }

    @PostMapping("/acceder")
    public String acceder(UserEntity usuario, HttpSession session) {
        log.info("Accesos : {}", usuario);
        Optional<UserEntity> user = userRepository.findByEmail(usuario.getEmail());
        log.info("Usuario de db: {}", user.get());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (user.isPresent()) {
            session.setAttribute("idusuario", user.get().getId());

            if (user.get().getUserType().equals("ADMIN")) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/admin/dashboard";
            }
        } else {
            log.info("Usuario no existe");
        }

        return "redirect:/";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model, HttpSession session) {
        model.addAttribute("usuarios", userService.findAll());
        model.addAttribute("nombre_session", session.getAttribute("nombre"));

        return "admin/usuarios";
    }
    
    @GetMapping("/edit/{id}")
    public String editUsuario(@PathVariable Integer id, Model model) {
        UserEntity usuarios = userService.getUserById(id);
        log.info("Usuarios obtenido: {}", usuarios);
        model.addAttribute("usuarios", usuarios);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "admin/edit";
    }
    
    // ELIMINAR usuario
    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Integer id) {

        userService.deleteUserById(id);

        //return "redirect:/admin/products/view";
        return "redirect:/admin/usuarios";
    }
}
