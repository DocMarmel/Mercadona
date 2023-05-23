package com.example.mercadona;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String label;
    private String description;
    private double price;
    // Colonne image en attente
//    private String image;
    private String category;
    private boolean promotion;
    private Timestamp startDatePromo;
    private Timestamp endDatePromo;
    private Integer discountPercentage;


    public Product() {

    }

    public Product(
            int id,
            String label,
            String description,
            double price,
//            String image,
            String category,
            boolean promotion,
            Timestamp startDatePromo,
            Timestamp endDatePromo,
            Integer discountPercentage) {

        this.id = id;
        this.label = label;
        this.description = description;
        this.price = price;
//        this.image = image;
        this.category = category;
        this.promotion = promotion;
        this.startDatePromo = startDatePromo;
        this.endDatePromo = endDatePromo;
        this.discountPercentage = discountPercentage;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getLabel() {

        return label;
    }

    public void setLabel(String label) {

        this.label = label;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public Timestamp getStartDatePromo() {
        return startDatePromo;
    }

    public void setStartDatePromo(Timestamp startDatePromo) {
        this.startDatePromo = startDatePromo;
    }

    public Timestamp getEndDatePromo() {
        return endDatePromo;
    }

    public void setEndDatePromo(Timestamp endDatePromo) {
        this.endDatePromo = endDatePromo;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
