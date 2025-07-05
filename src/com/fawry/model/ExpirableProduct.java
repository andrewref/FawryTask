package com.fawry.model;

import java.time.LocalDate;

import com.fawry.service.Shippable;

public class ExpirableProduct extends Product implements Shippable {
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
    public double getWeight() {
        return weightKg;
    }
    public String getName() {
        return name;
    }
}
