/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.repository;

import upeu.edu.pe.ProjectLP2.infrastructure.entity.DetailOrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;

/**
 *
 * @author alejandromacedop
 */
public interface DetailOrderRepository {
    
     //LISTA DE TODAS LOS DETALLES
    Iterable<DetailOrderEntity> getDetailOrder();
    
    //LISTA DE DETALLE POR ORDEN
    Iterable<DetailOrderEntity> getDetailOrderByOrder(OrderEntity order);
    
    DetailOrderEntity getDetailOrderById(Integer id);

    DetailOrderEntity saveDetailOrde(DetailOrderEntity detailorder);

    void deleteDetailOrderById(Integer id);
}
