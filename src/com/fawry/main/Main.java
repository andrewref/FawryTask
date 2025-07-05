package com.fawry.main;

import com.fawry.cart.Cart;
import com.fawry.model.ExpirableProduct;
import com.fawry.model.ScratchCard;
import com.fawry.model.ShippableProduct;
import com.fawry.service.CheckoutService;
import com.fawry.service.Customer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();

        System.out.println("Test 1");
        Customer customer1 = new Customer("Ahmed", 1000);
        ExpirableProduct cheese1 = new ExpirableProduct("Cheese", 100, 5, LocalDate.of(2025, 7, 30), 0.2);
        ExpirableProduct biscuits1 = new ExpirableProduct("Biscuits", 150, 3, LocalDate.of(2025, 7, 30), 0.7);
        Cart cart1 = new Cart();
        cart1.add(cheese1, 2);
        cart1.add(biscuits1, 1);
        checkout.checkout(customer1, cart1);
        System.out.println();

        System.out.println("Test 2");
        Customer customer2 = new Customer("Nada", 1000);
        Cart cart2 = new Cart();
        checkout.checkout(customer2, cart2);
        System.out.println();

        System.out.println("Test 3");
        Customer customer3 = new Customer("Hany", 50);
        Cart cart3 = new Cart();
        cart3.add(cheese1, 2);
        cart3.add(biscuits1, 1);
        checkout.checkout(customer3, cart3);
        System.out.println();

        System.out.println("Test 4");
        Customer customer4 = new Customer("Yara", 1000);
        ExpirableProduct expiredCheese = new ExpirableProduct("Old Cheese", 100, 5, LocalDate.of(2020, 1, 1), 0.2);
        Cart cart4 = new Cart();
        try {
            cart4.add(expiredCheese, 1);
            checkout.checkout(customer4, cart4);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        System.out.println("Test 5");
        Customer customer5 = new Customer("Ziad", 1000);
        ExpirableProduct fewBiscuits = new ExpirableProduct("Biscuits", 150, 1, LocalDate.of(2025, 7, 30), 0.7);
        Cart cart5 = new Cart();
        try {
            cart5.add(fewBiscuits, 2);
            checkout.checkout(customer5, cart5);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        System.out.println("Test 6");
        Customer customer6 = new Customer("Khaled", 1000);
        ScratchCard scratchCard = new ScratchCard("Scratch Card", 50, 10);
        Cart cart6 = new Cart();
        cart6.add(scratchCard, 3);
        checkout.checkout(customer6, cart6);
        System.out.println();

        System.out.println("Test 7");
        Customer customer7 = new Customer("Mona", 2000);
        ShippableProduct tv = new ShippableProduct("TV", 3000, 2, 7.5);
        Cart cart7 = new Cart();
        cart7.add(tv, 1);
        cart7.add(scratchCard, 2);
        checkout.checkout(customer7, cart7);
        System.out.println();
    }
}
