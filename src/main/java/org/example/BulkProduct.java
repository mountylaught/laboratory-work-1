package org.example;

public class BulkProduct extends Product {
    private double weightPerUnit; // Вес одной единицы

    public BulkProduct(String articul, String name, double price, int quantity, double minStock, Dimensions dimensions, double weightPerUnit) {
        super(articul, name, price, quantity, minStock, dimensions);

        if (weightPerUnit <= 0) {
            throw new IllegalArgumentException("Вес за единицу должен быть больше нуля");
        }
        this.weightPerUnit = weightPerUnit;
    }

    public double getWeightPerUnit() {
        return weightPerUnit;
    }

    @Override
    public double calculateStorageCost() {
        return getQuantity() * weightPerUnit * 2.5;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", вес за ед.: %.2f кг", weightPerUnit);
    }
}