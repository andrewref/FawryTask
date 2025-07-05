package com.fawry.cart;

import com.fawry.model.Product;

 public class CartItem {

    private final Product product;
    private final int quantity;

    public CartItem(Product product,int quantity) {
        this.product  =product;
        this.quantity =quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    public String toString() {
        return quantity + " × " + product.getName();
    }
}
