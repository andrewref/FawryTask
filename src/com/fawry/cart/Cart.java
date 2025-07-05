package com.fawry.cart;

import com.fawry.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items=new ArrayList<>();
    
    public void add(Product product,int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (product.getQuantity() < quantity) {
            throw new IllegalStateException("Not enough stock for " + product.getName());
        }
        if (product.isExpired()) {
            throw new IllegalStateException("Product is expired: " + product.getName());
        }
        items.add(new CartItem(product,quantity));
        product.reduceQuantity(quantity);
    }
    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
