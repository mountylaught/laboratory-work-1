package org.example;

public class BulkCalculation implements CalculationStrategy {
    private final double weightPerUnit;

    public BulkCalculation(double weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    @Override
    public double calculateStorageCost(double price, int quantity) {
        return quantity * weightPerUnit * 2.5;
    }
}