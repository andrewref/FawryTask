package com.fawry.model;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;
    private double weightKg;

    public ExpirableProduct(String name,double price,int quantity,LocalDate expiryDate,double weightKg) {
        super(name, price, quantity);
        this.expiryDate=expiryDate;
        this.weightKg=weightKg;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public boolean isShippable() {
        return weightKg > 0;
    }

    public double getWeightKg() {
        return weightKg;
    }
}
