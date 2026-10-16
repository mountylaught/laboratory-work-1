package org.example;

import java.util.Arrays;

public class Warehouse {
    private Product[] products;
    private int count;

    public Warehouse(int capacity) {
        products = new Product[capacity];
        count = 0;
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
                return products[i]; // нашли
            }
        }
        return null;
    }

    public Product[] getProducts() {
        return Arrays.copyOf(products, count);
    }
}