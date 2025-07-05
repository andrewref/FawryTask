package com.fawry.model;

public class ShippableProduct extends Product {
	private double weightKg;
    public ShippableProduct(String name, double price,int quantity,double weightKg) {
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

}
