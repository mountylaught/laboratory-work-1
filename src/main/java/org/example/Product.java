package org.example;

// КЛАСС-СУЩНОСТЬ
public class Product {

    // СТАТИЧЕСКИЕ ЧЛЕНЫ
    public static final double VAT = 0.22; // НДС
    private static int totalCreated = 0; // СЧЕТЧИК ТОВАРОВ

    // ПОЛЯ СУЩНОСТИ
    private final String articul;
    private String name;
    private double price;
    private int quantity;
    private double minStock;
    private Dimensions dimensions;

    // КОНСТРУКТОР (инварианты)
    public Product(String articul, String name, double price, int quantity, double minStock, Dimensions dimensions) {

        if (articul == null || articul.isEmpty()) {
            throw new IllegalArgumentException("Артикул не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным");
        }
        if (dimensions == null) {
            throw new IllegalArgumentException("Габариты не могут быть null");
        }

        // сохранение данных
        this.articul = articul;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.minStock = minStock;
        this.dimensions = dimensions;

        // +1 созданный товар
        totalCreated++;
    }

    // геттер счетчика
    public static int getTotalCreated() {
        return totalCreated;
    }

    // ПЕРЕГРУЗКА МЕТОДОВ

    // 1-я версия (без параметров) ставка НДС
    public double priceWithTax() {
        return price * (1 + VAT);
    }

    // 2-я версия (с параметром) своя ставка налога
    public double priceWithTax(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Ставка налога не может быть отрицательной");
        }
        return price * (1 + rate);
    }

    // типо свой сеттер с проверкой
    public void ship(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество должно быть > 0");
        }
        if (amount > this.quantity) {
            throw new IllegalStateException("Нельзя отгрузить больше, чем есть на складе");
        }

        this.quantity -= amount; // если все ок, уменьшаем количество товара на складе
    }

    // геттеры
    public String getArticul() { return articul; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Dimensions getDimensions() { return dimensions; }

    // красивый вывод на экран
    public String toString() {
        return String.format("Товар [%s] '%s': цена=%.2f, шт=%d", articul, name, price, quantity);
    }
}
