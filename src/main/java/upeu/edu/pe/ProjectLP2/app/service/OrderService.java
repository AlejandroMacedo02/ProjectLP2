/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.service;

import upeu.edu.pe.ProjectLP2.app.repository.OrderRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public class OrderService {
    
   private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
   
    //LISTA DE TODAS LAS ORDENES
    public Iterable<OrderEntity> getOrder(){
        return orderRepository.getOrder();
    }

    //LISTA DE ORDEN POR USUARIO
    
    public Iterable<OrderEntity> getOrderByUser(UserEntity user){
        return orderRepository.getOrderByUser(user);
    }

    public OrderEntity getOrderById(Integer id){
        return orderRepository.getOrderById(id);
    }

    public OrderEntity saveOrder(OrderEntity order){
        return orderRepository.saveOrder(order);
    }

    public void deleteOrderById(Integer id){
        orderRepository.deleteOrderById(id);
    }
   
}
