package org.example;

public class Product {

    public static final double VAT = 0.22;
    private static int totalCreated = 0;

    private final String articul;
    private String name;
    private double price;
    private int quantity;
    private double minStock;
    private Dimensions dimensions;

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

        this.articul = articul;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.minStock = minStock;
        this.dimensions = dimensions;

        totalCreated++;
    }

    public static int getTotalCreated() {
        return totalCreated;
    }

    public double priceWithTax() {
        return price * (1 + VAT);
    }

    public double priceWithTax(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Ставка налога не может быть отрицательной");
        }
        return price * (1 + rate);
    }

    public void ship(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество должно быть > 0");
        }
        if (amount > this.quantity) {
            throw new IllegalStateException("Нельзя отгрузить больше, чем есть на складе");
        }

        this.quantity -= amount;
    }

    public String getArticul() { return articul; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Dimensions getDimensions() { return dimensions; }

    public String toString() {
        return String.format("Товар [%s] '%s': цена=%.2f, шт=%d", articul, name, price, quantity);
    }
}
