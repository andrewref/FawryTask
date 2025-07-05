package com.fawry.model;

import com.fawry.service.Shippable;

public class ShippableProduct extends Product implements Shippable {
	private double weightKg;
    public ShippableProduct(String name,double price,int quantity,double weightKg) {
        super(name,price,quantity);
        this.weightKg=weightKg;
    }
    public boolean isExpired() {
        return false;
    }
    public boolean isShippable() {
        return true;
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
