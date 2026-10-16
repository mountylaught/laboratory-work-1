package org.example;

import java.util.Arrays;

public class Warehouse {
    private Product[] products;
    private int count;

    public Warehouse(int capacity) {
        products = new Product[capacity];
        count = 0;
    }

    public boolean addProductWithRule(Product p, StorageRule rule) {
        if (count >= products.length) {
            throw new IllegalStateException("Склад переполнен");
        }

        if (!rule.checkStorage(p)) {
            System.out.println("Товар " + p.getName() + " не прошел проверку правил хранения!");
            return false;
        }

        products[count++] = p;
        System.out.println("Товар успешно размещен на складе по правилу.");
        return true;
    }

    public void addProduct(Product p) {
        if (count >= products.length) {
            throw new IllegalStateException("Склад переполнен");
        }
        products[count++] = p;
    }

    public Product findByArticul(String articul) {
        for (int i = 0; i < count; i++) {
            if (products[i].getArticul().equals(articul)) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] getProducts() {
        return Arrays.copyOf(products, count);
    }
}