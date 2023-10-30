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
import upeu.edu.pe.ProjectLP2.app.service.DetailOrderService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;

/**
 *
 * @author alejandromacedop
 */
@RestController
@RequestMapping("/api/v1/detailorder/")
public class DetailOrderControllerApi {
 
    private final DetailOrderService detailOrderService;

    public DetailOrderControllerApi(DetailOrderService detailOrderService) {
        this.detailOrderService = detailOrderService;
    }
    
    //crear detalle 
    @PostMapping("/save-detailorder")
    public String saveDetailOrder(@RequestBody DetailOrderEntity detailOrderEntity) {
        return detailOrderService.saveDetailOrder(detailOrderEntity).toString();
    }
    //ver un detalle

    @GetMapping("/show")
    public Iterable<DetailOrderEntity> showDetalOrder() {
        OrderEntity order = new OrderEntity();
        order.setId(1);
        return detailOrderService.getDetailOrderByOrder(order);
    }

    //buscar detalle orden por producto
    @GetMapping("/show/{id}")
    public DetailOrderEntity show(@PathVariable Integer id) {
        return detailOrderService.getDetailOrderById(id);
    }
    
    //editar una orden
    /*@PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DetailOrderEntity editDetailOrder(@RequestBody DetailOrderEntity detailorder, @PathVariable Integer id) {
        DetailOrderEntity detailOrderActual = detailOrderService.getDetailOrderById(id);
        detailOrderActual.setCode(detailorder.getCode());
        detailOrderActual.setTotal(detailorder.getTotal());
        detailOrderActual.setPrecioUnitario(detailorder.getPrecioUnitario());
        detailOrderActual.setCantidadProducto(detailorder.getCantidadProducto());
        return detailOrderService.saveDetailOrder(detailOrderActual);
        
        // log.info("Product obtenido: {}", product);
        //model.addAttribute("product", product);
        //return "admin/products/edit";
    }*/

    //eliminar una orden
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer id) {
        detailOrderService.deleteOrderById(id);
        // return "redirect:/admin/products/show";
    }
}
