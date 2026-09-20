package org.example;

import java.util.Arrays; // импорт чтобы с массивами работать

public class Warehouse {
    private Product[] products;
    private int count; // текущее количество товаров на складе

    // контейнер с фиксированной вместимостью
    public Warehouse(int capacity) {
        products = new Product[capacity];
        count = 0;
    }

    // добавление товара в контейнер
    public void addProduct(Product p) {
        if (count >= products.length) {
            throw new IllegalStateException("Склад переполнен");
        }
        products[count++] = p; // запись товара в массив и увеличение счетчика
    }

    // поиск товара по артикулу
    public Product findByArticul(String articul) {
        for (int i = 0; i < count; i++) {
            if (products[i].getArticul().equals(articul)) {
                return products[i]; // нашли
            }
        }
        return null; // не нашли
    }

    // возвращение безопасной копии, чтобы избежать изменений
    public Product[] getProducts() {
        return Arrays.copyOf(products, count);
    }
}