package com.example.webshopapi.controller;

import com.example.webshopapi.dao.ProductDAO;
import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.ApiResponse;
import com.example.webshopapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse all() {
        return new ApiResponse(HttpStatus.ACCEPTED, this.productDAO.all());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse get(@PathVariable UUID id) {
        Product product;
        try {
            product = this.productDAO.getById(id);
        } catch (NotFoundException exception) {
            return new ApiResponse(HttpStatus.NOT_FOUND, "No product with that id");
        }
        return new ApiResponse(HttpStatus.ACCEPTED, product);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse save(@RequestBody Product newProduct){
        Product product = this.productDAO.save(newProduct);
        return new ApiResponse(HttpStatus.ACCEPTED, product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse replace(@RequestBody Product product, @PathVariable UUID id){
        try{
            this.productDAO.replace(product, id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You replaced product: " + product.getProductID() + " successfully.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse update(@RequestBody Product product, @PathVariable UUID id){
        try{
            this.productDAO.update(product, id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You updated product: " + product.getProductID() + " successfully.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public ApiResponse delete(@PathVariable UUID id){
        try{
            this.productDAO.delete(id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You deleted product: " + id + " successfully.");
    }
}