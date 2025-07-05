package com.fawry.service;

import com.fawry.cart.Cart;
import com.fawry.cart.CartItem;
import com.fawry.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private final ShippingService shippingService =new ShippingService();

    public void checkout(Customer customer,Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cannot checkout. Cart is empty.");
            return;
        }
        List<CartItem> items = cart.getItems();
        double subtotal = 0;
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            double lineTotal = product.getPrice() * quantity;
            subtotal += lineTotal;

            if (product.isShippable() && product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }

        double shippingFee = shippableItems.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            System.out.printf("Not enough balance. Required: %.0f — Available: %.0f%n",total,customer.getBalance());
            return;
        }
        customer.pay(total);

        if (!shippableItems.isEmpty()) {
            shippingService.ship(shippableItems);
            System.out.println();
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            double lineTotal = product.getPrice() * quantity;
            System.out.printf("%dx %-10s %6.0f\n",quantity,product.getName(),lineTotal);
        }
        System.out.println("----------------------");
        System.out.printf("%-13s %6.0f\n", "Subtotal", subtotal);
        System.out.printf("%-13s %6.0f\n", "Shipping", shippingFee);
        System.out.printf("%-13s %6.0f\n", "Amount", total);

    }
}
