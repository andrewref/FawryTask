package com.fawry.service;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;

public class ShippingService {

    public void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCount = new LinkedHashMap<>();
        Map<String, Double> itemWeight = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            itemCount.put(name, itemCount.getOrDefault(name, 0) + 1);
            itemWeight.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : itemCount.keySet()) {
            int qty = itemCount.get(name);
            int weightGrams = (int) (itemWeight.get(name) * 1000);
            System.out.printf("%dx %-11s %4dg\n", qty, name, weightGrams);
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
