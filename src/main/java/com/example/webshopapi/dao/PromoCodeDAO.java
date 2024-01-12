package com.example.webshopapi.dao;

import com.example.webshopapi.exception.NotFoundException;
import com.example.webshopapi.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Component
public class PromoCodeDAO {

    @Autowired
    private PromoCodeRepository promoCodeRepository;

    public ArrayList<PromoCode> all() {
        ArrayList<PromoCode> allPromoCodes = (ArrayList<PromoCode>) this.promoCodeRepository.findAll();
        return allPromoCodes;
    }

    public PromoCode getById(UUID id) {
        Optional<PromoCode> optionalPromoCode = this.promoCodeRepository.findById(id);
        if (optionalPromoCode.isEmpty()) {
            throw new NotFoundException("PromoCode with id: " + id + " not found");
        }
        return optionalPromoCode.get();
    }

    public PromoCode save(PromoCode newPromoCode) {
        PromoCode promoCode = this.promoCodeRepository.save(newPromoCode);
        return promoCode;
    }

    public PromoCode replace(PromoCode newPromoCode, UUID id) throws NotFoundException {
        Optional<PromoCode> optionalPromoCode = this.promoCodeRepository.findById(id);

        if (optionalPromoCode.isEmpty()) {
            throw new NotFoundException("PromoCode with id: " + id + " not found");
        }

        PromoCode currentPromoCode = optionalPromoCode.get();
        currentPromoCode.setPromoCodeID(newPromoCode.getPromoCodeID());
        currentPromoCode.setPromocode(newPromoCode.getPromocode());
        currentPromoCode.setDiscount(newPromoCode.getDiscount());

        this.promoCodeRepository.save(currentPromoCode);
        return currentPromoCode;
    }

    public PromoCode update(PromoCode updatedPromoCode, UUID id) throws NotFoundException {
        Optional<PromoCode> optionalPromoCode = this.promoCodeRepository.findById(id);

        if (optionalPromoCode.isEmpty()) {
            throw new NotFoundException("PromoCode with id: " + id + " not found");
        }

        PromoCode currentPromoCode = optionalPromoCode.get();
        currentPromoCode.setPromoCodeID(updatedPromoCode.getPromoCodeID());
        currentPromoCode.setPromocode(updatedPromoCode.getPromocode());
        currentPromoCode.setDiscount(updatedPromoCode.getDiscount());

        this.promoCodeRepository.save(currentPromoCode);
        return currentPromoCode;
    }

    public void delete(UUID id) throws NotFoundException {
        Optional<PromoCode> optionalPromoCode = this.promoCodeRepository.findById(id);

        if (optionalPromoCode.isEmpty()) {
            throw new NotFoundException("PromoCode with id: " + id + " not found");
        }

        PromoCode promoCode = optionalPromoCode.get();
        this.promoCodeRepository.delete(promoCode);
    }
}
