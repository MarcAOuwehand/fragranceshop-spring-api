package com.example.webshopapi.controller;

import com.example.webshopapi.dao.PromoCodeDAO;
import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.ApiResponse;
import com.example.webshopapi.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/promocodes")
public class PromoCodeController {

    @Autowired
    private PromoCodeDAO promoCodeDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse all() {
        return new ApiResponse(HttpStatus.ACCEPTED, this.promoCodeDAO.all());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse get(@PathVariable UUID id) {
        PromoCode promoCode;
        try {
            promoCode = this.promoCodeDAO.getById(id);
        } catch (NotFoundException exception) {
            return new ApiResponse(HttpStatus.NOT_FOUND, "No promo code with that id");
        }
        return new ApiResponse(HttpStatus.ACCEPTED, promoCode);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse save(@RequestBody PromoCode newPromoCode){
        PromoCode promoCode = this.promoCodeDAO.save(newPromoCode);
        return new ApiResponse(HttpStatus.ACCEPTED, promoCode);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse replace(@RequestBody PromoCode promoCode, @PathVariable UUID id){
        try{
            this.promoCodeDAO.replace(promoCode, id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You replaced promo code: " + promoCode.getPromoCodeID() + " successfully.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseBody
    public ApiResponse update(@RequestBody PromoCode promoCode, @PathVariable UUID id){
        try{
            this.promoCodeDAO.update(promoCode, id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You updated promo code: " + promoCode.getPromoCodeID() + " successfully.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse delete(@PathVariable UUID id){
        try{
            this.promoCodeDAO.delete(id);
        } catch(NotFoundException exception){
            return new ApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        }

        return new ApiResponse(HttpStatus.ACCEPTED, "You deleted promo code: " + id + " successfully.");
    }
}
