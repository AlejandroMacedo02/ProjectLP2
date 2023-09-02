package upeu.edu.pe.ProjectLP2.app.repository;

import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public interface OrderRepository {
    
    //LISTA DE TODAS LAS ORDENES
    Iterable<OrderEntity> getOrder();

    //LISTA DE ORDEN POR USUARIO
    
    Iterable<OrderEntity> getOrderByUser(UserEntity user);

    OrderEntity getOrderById(Integer id);

    OrderEntity saveOrder(OrderEntity order);

    void deleteOrderById(Integer id);
}
