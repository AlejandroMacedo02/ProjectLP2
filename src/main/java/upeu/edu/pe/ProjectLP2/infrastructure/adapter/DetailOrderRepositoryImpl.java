/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ProjectLP2.app.repository.DetailOrderRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;

/**
 *
 * @author alejandromacedop
 */
@Repository
public class DetailOrderRepositoryImpl implements DetailOrderRepository{
    private final DetailOrderCrudRepository detailOrderCrudRepository;

    public DetailOrderRepositoryImpl(DetailOrderCrudRepository detailOrderCrudRepository) {
        this.detailOrderCrudRepository = detailOrderCrudRepository;
    }

    @Override
    public Iterable<DetailOrderEntity> getDetailOrder() {
        return detailOrderCrudRepository.findAll();
    }

    @Override
    public Iterable<DetailOrderEntity> getDetailOrderByOrder(OrderEntity order) {
        return detailOrderCrudRepository.findByOrderEntity(order);
    }

    @Override
    public DetailOrderEntity getDetailOrderById(Integer id) {
        return detailOrderCrudRepository.findById(id).get();
    }

    @Override
    public DetailOrderEntity saveDetailOrde(DetailOrderEntity detailorder) {
        return detailOrderCrudRepository.save(detailorder);
    }

    @Override
    public void deleteDetailOrderById(Integer id) {
        detailOrderCrudRepository.deleteById(id);
    }
    
    
}
