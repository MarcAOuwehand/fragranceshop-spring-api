package com.example.webshopapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productID;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name must not be longer than 50 characters")
    private String name;

    @NotBlank(message = "Image path is mandatory")
    @Size(max = 250, message = "Image path must not be longer than 250 characters")
    private String img_path;

    @PositiveOrZero(message = "Price must not be negative")
    private double price;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 250, message = "Description must not be longer than 250 characters")
    private String description;

    @NotBlank(message = "Brand is mandatory")
    @Size(max = 50, message = "Brand must not be longer than 50 characters")
    private String brand;

    public UUID getProductID() {
        return productID;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String type) {
        this.brand = type;
    }
}