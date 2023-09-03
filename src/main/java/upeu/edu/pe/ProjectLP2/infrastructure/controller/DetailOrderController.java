package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.service.DetailOrderService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("/admin/detailorder")
public class DetailOrderController {

    private final DetailOrderService detailOrderService;
    private final org.slf4j.Logger log = LoggerFactory.getLogger(DetailOrderController.class);

    public DetailOrderController(DetailOrderService detailOrderService) {
        this.detailOrderService = detailOrderService;
    }

    //CREAR DETALLE ORDEN
    @GetMapping("/create")
    public String create() {
        return "admin/detailorder/create";
    }
    
     //MOSTRAR ORDEN
    
    @GetMapping("/show")
    public String showDetailOrder(Model model) {
        //log.info("id user desde la variable de session: {}");
        OrderEntity order = new OrderEntity();
        order.setId(1);
        Iterable<DetailOrderEntity> detailorder = detailOrderService.getDetailOrderByOrder(order);
        model.addAttribute("detailorder", detailorder);
        return "admin/detailorder/show";
    }

    //EDITAR ORDEN
    
    @GetMapping("/edit/{id}")
    public String editDetailOrder(@PathVariable Integer id, Model model) {
        DetailOrderEntity orderdetail = detailOrderService.getDetailOrderById(id);
        log.info("detailOrder obtenido: {}", orderdetail);
        model.addAttribute("detailorder", orderdetail);
        return "admin/detailorder/edit";
    }
    
    // ELIMINAR ORDEN
    
    @GetMapping("/delete/{id}")
    public String deleteDetailOrder(@PathVariable Integer id) {
        detailOrderService.deleteOrderById(id);
        return "redirect:/admin/detailorder/show";
    }
}
