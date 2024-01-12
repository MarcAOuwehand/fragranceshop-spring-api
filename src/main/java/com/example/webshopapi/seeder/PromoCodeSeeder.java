package com.example.webshopapi.seeder;

import com.example.webshopapi.dao.ProductDAO;
import com.example.webshopapi.dao.PromoCodeDAO;
import com.example.webshopapi.model.Product;
import com.example.webshopapi.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PromoCodeSeeder {
    @Autowired
    private PromoCodeDAO promoCodeDAO;

    public void seed() {
        PromoCode promoCode1 = new PromoCode();
        promoCode1.setPromoCodeID(UUID.randomUUID());
        promoCode1.setPromocode("LOVEIPRWC");
        promoCode1.setDiscount(10);
        promoCodeDAO.save(promoCode1);

    }
}