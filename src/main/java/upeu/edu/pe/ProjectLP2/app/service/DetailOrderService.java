/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.service;

import upeu.edu.pe.ProjectLP2.app.repository.DetailOrderRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;

/**
 *
 * @author alejandromacedop
 */
public class DetailOrderService {
    
    private final DetailOrderRepository detailOrderRepository;
    
    public DetailOrderService(DetailOrderRepository detailOrderRepository) {
        this.detailOrderRepository = detailOrderRepository;
    }
    
     //LISTA DE TODAS LOS DETALLES
    public Iterable<DetailOrderEntity> getDetailOrder(){
        return detailOrderRepository.getDetailOrder();
    }
    
    //LISTA DE DETALLE POR ORDEN
    public Iterable<DetailOrderEntity> getDetailOrderByOrder(OrderEntity order){
        return detailOrderRepository.getDetailOrderByOrder(order);
    }
    
    public DetailOrderEntity getDetailOrderById(Integer id){
        return detailOrderRepository.getDetailOrderById(id);
    }

    public DetailOrderEntity saveDetailOrder(DetailOrderEntity detailorder){
        return detailOrderRepository.saveDetailOrde(detailorder);
    }

    public void deleteOrderById(Integer id){
        detailOrderRepository.deleteDetailOrderById(id);
    }
        
}
