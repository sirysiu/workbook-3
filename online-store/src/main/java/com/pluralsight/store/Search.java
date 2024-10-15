package com.pluralsight.store;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private List<Products> items;

    public Search() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Products products) {
        items.add(products);

    }

    public void removeProducts(String sku) {
        items.removeIf(item -> item.getSku().equals(sku));
    }

    public double totalPrice() {
        return items.stream().mapToDouble(Products::getPrice).sum();

    }

    public void displayCart() {
        for (Products item : items) {
            System.out.println(item.getName() + "- $" + item.getPrice());
        }
        System.out.printf("Total $%.2f%n", totalPrice());
    }

    public List<Products> getItems() {
        return items;
    }
}
