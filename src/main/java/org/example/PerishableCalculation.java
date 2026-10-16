package org.example;

public class PerishableCalculation implements CalculationStrategy {
    private final int expirationDays;

    public PerishableCalculation(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    @Override
    public double calculateStorageCost(double price, int quantity) {
        return price * 0.15 + (expirationDays < 7 ? 50.0 : 10.0);
    }
}