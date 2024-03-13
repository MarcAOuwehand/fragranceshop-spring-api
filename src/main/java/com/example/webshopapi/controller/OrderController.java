package com.example.webshopapi.controller;

import com.example.webshopapi.dao.OrderDAO;
import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.ApiResponse;
import com.example.webshopapi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse all() {
        return new ApiResponse(HttpStatus.ACCEPTED, this.orderDAO.all());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse get(@PathVariable UUID id) {
        Order order;
        try {
            order = this.orderDAO.getById(id);
        } catch (NotFoundException exception) {
            return new ApiResponse(HttpStatus.NOT_FOUND, "No cart with that id");
        }
        return new ApiResponse(HttpStatus.ACCEPTED, order);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse save(@RequestBody Order newOrder){
        Order order = this.orderDAO.save(newOrder);
        return new ApiResponse(HttpStatus.ACCEPTED, order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse replace(@RequestBody Order order, @PathVariable UUID id){
        try{
            this.orderDAO.replace(order, id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You replaced cart: " + order.getOrderID() + " successfully.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse update(@RequestBody Order order, @PathVariable UUID id){
        try{
            this.orderDAO.update(order, id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You updated cart: " + order.getOrderID() + " successfully.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse delete(@PathVariable UUID id){
        try{
            this.orderDAO.delete(id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You deleted cart: " + id + " successfully.");
    }
}