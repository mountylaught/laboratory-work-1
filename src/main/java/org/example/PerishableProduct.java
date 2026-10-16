package org.example;

public class PerishableProduct extends Product {
    private int expirationDays; // Срок годности

    public PerishableProduct(String articul, String name, double price, int quantity, double minStock, Dimensions dimensions, int expirationDays) {
        super(articul, name, price, quantity, minStock, dimensions);

        if (expirationDays <= 0) {
            throw new IllegalArgumentException("Срок годности должен быть больше нуля");
        }
        this.expirationDays = expirationDays;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    @Override
    public double calculateStorageCost() {
        return getPrice() * 0.15 + (expirationDays < 7 ? 50.0 : 10.0);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", срок годности: %d дн.", expirationDays);
    }
}