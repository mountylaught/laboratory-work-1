package org.example;

public class FragileCalculation implements CalculationStrategy {
    private final double insuranceFee;

    public FragileCalculation(double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    @Override
    public double calculateStorageCost(double price, int quantity) {
        return price * 0.10 + insuranceFee;
    }
}