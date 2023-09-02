package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.service.OrderService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/admin/orders")
public class OrderController {
    
    private final OrderService orderService;
    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    //CREAR ORDEN
    
    @GetMapping("/create")
    public String create() {
        return "admin/orders/create";
    }

    //GUARDAR ORDEN
    
    @PostMapping("/save-order")
    public String saveOrder(OrderEntity order) {
        log.info("Nombre de orden: {}", order);
        orderService.saveOrder(order);
        return "admin/orders/create";
        //return "redirect:/admin";
    }
    
    //MOSTRAR ORDEN
    
    @GetMapping("/show")
    public String showOrder(Model model) {
        //log.info("id user desde la variable de session: {}");
        UserEntity user = new UserEntity();
        user.setId(1);
        Iterable<OrderEntity> order = orderService.getOrderByUser(user);
        model.addAttribute("orders", order);
        return "admin/orders/show";
    }

    //EDITAR ORDEN
    
    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable Integer id, Model model) {
        OrderEntity order = orderService.getOrderById(id);
        log.info("Order obtenido: {}", order);
        model.addAttribute("order", order);
        return "admin/orders/edit";
    }
    
    // ELIMINAR ORDEN
    
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
        return "redirect:/admin/orders/show";
    }
}
