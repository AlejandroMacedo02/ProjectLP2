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
import upeu.edu.pe.ProjectLP2.app.service.OrderService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
@RestController
@RequestMapping("/api/v1/order/")
public class OrderControllerApi {
    
    private final OrderService orderService;

    public OrderControllerApi(OrderService orderService) {
        this.orderService = orderService;
    }
    
    //crear una orden
    @PostMapping("/save-order")
    public String saveOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.saveOrder(orderEntity).toString();
    }
    //ver orden

    @GetMapping("/show")
    public Iterable<OrderEntity> showProduct() {
        UserEntity user = new UserEntity();
        user.setId(1);
        return orderService.getOrderByUser(user);
    }

    //buscar orden por Id
    @GetMapping("/show/{id}")
    public OrderEntity show(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    //editar una orden
    /*@PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEntity editProduct(@RequestBody OrderEntity order, @PathVariable Integer id) {
        OrderEntity orderActual = orderService.getOrderById(id);
        orderActual.setCode(order.getCode());
        orderActual.setDesciption(order.getDesciption());
        orderActual.setDireccion_envio(order.getDireccion_envio());
        orderActual.setTotal(order.getTotal());
        orderActual.setUserEntity(order.getUserEntity());
        
        return orderService.saveOrder(orderActual);
        // log.info("Product obtenido: {}", product);
        //model.addAttribute("product", product);
        //return "admin/products/edit";
    }

    //eliminar una orden
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
        // return "redirect:/admin/products/show";
    }*/
}
