package com.example.webshopapi.dao;

import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderDAO {

    @Autowired
    private OrderRepository orderRepository;

    public ArrayList<Order> all(){
        ArrayList<Order> allOrders = (ArrayList<Order>) this.orderRepository.findAll();
        return allOrders;
    }

    public Order getById(UUID id){
        Optional<Order> optionalOrder = this.orderRepository.findById(id);
        if(optionalOrder.isEmpty()){
            throw new NotFoundException("Cart with id: " + id + "not found");
        }
        return optionalOrder.get();
    }

    public Order save(Order newOrder){
        Order order = this.orderRepository.save(newOrder);
        return order;
    }

    public Order replace(Order newOrder, UUID id) throws NotFoundException{
        Optional<Order> optionalOrder = this.orderRepository.findById(id);

        if(optionalOrder.isEmpty()){
            throw new NotFoundException("Cart with id: " + id + " not found");
        }

        Order currentOrder = optionalOrder.get();
        currentOrder.setOrderID(newOrder.getOrderID());
        currentOrder.setUserID(newOrder.getUserID());

        this.orderRepository.save(currentOrder);
        return currentOrder;
    }


    public Order update(Order updatedOrder, UUID id) throws NotFoundException{
        Optional<Order> optionalOrder = this.orderRepository.findById(id);

        if(optionalOrder.isEmpty()){
            throw new NotFoundException("Cart with id: " + id + " not found");
        }

        Order currentOrder = optionalOrder.get();

        currentOrder.setOrderID(updatedOrder.getOrderID());
        currentOrder.setUserID(updatedOrder.getUserID());

        this.orderRepository.save(currentOrder);
        return currentOrder;
    }

    public void delete(UUID id) throws NotFoundException{
        Optional<Order> optionalOrder = this.orderRepository.findById(id);

        if(optionalOrder.isEmpty()){
            throw new NotFoundException("Order with id: " + id + " not found");
        }

        Order order = optionalOrder.get();
        this.orderRepository.delete(order);
    }
}
