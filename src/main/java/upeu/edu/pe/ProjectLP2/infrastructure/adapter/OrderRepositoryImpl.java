package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ProjectLP2.app.repository.OrderRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepositoy orderCrudRepositoy;

    public OrderRepositoryImpl(OrderCrudRepositoy orderCrudRepositoy) {
        this.orderCrudRepositoy = orderCrudRepositoy;
    }

    @Override
    public Iterable<OrderEntity> getOrder() {
        return orderCrudRepositoy.findAll();
    }

    @Override
    public Iterable<OrderEntity> getOrderByUser(UserEntity user) {
        return orderCrudRepositoy.findByUserEntity(user);
    }

    @Override
    public OrderEntity getOrderById(Integer id) {
        return orderCrudRepositoy.findById(id).get();
    }

    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        return orderCrudRepositoy.save(order);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderCrudRepositoy.deleteById(id);
    }
    
    
}
