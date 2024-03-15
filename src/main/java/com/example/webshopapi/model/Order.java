package com.example.webshopapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderID;

    @NotNull
    private UUID userID;

    public UUID getOrderID() {
        return orderID;
    }

    public void setOrderID(UUID orderID) {
        this.orderID = orderID;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

}
