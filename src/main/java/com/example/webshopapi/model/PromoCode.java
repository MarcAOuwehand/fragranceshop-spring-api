package com.example.webshopapi.model;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "promocodes")
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID promoCodeID;
    private String promocode;
    private int discount;

    public UUID getPromoCodeID() {
        return promoCodeID;
    }

    public void setPromoCodeID(UUID orderID) {
        this.promoCodeID = orderID;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

