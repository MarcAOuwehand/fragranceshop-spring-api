package com.example.webshopapi.controller;

import com.example.webshopapi.dao.UserDAO;
import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.ApiResponse;
import com.example.webshopapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse all() {
        return new ApiResponse(HttpStatus.ACCEPTED, this.userDAO.all());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse get(@PathVariable UUID id) {
        User user;
        try {
            user = this.userDAO.getById(id);
        } catch (NotFoundException exception) {
            return new ApiResponse(HttpStatus.NOT_FOUND, "No user with that id");
        }
        return new ApiResponse(HttpStatus.ACCEPTED, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse delete(@PathVariable UUID id){
        try{
            this.userDAO.delete(id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You deleted user: " + id + " successfully.");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse save(@RequestBody User newUser){
        User user = this.userDAO.save(newUser);
        return new ApiResponse(HttpStatus.ACCEPTED, user);
    }
}