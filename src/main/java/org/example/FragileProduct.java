package org.example;

public class FragileProduct extends Product {
    private double insuranceFee; // Стоимость страховки при перевозке хрупкого товара

    public FragileProduct(String articul, String name, double price, int quantity, double minStock, Dimensions dimensions, double insuranceFee) {
        super(articul, name, price, quantity, minStock, dimensions);

        if (insuranceFee < 0) {
            throw new IllegalArgumentException("Страховка не может быть отрицательной");
        }
        this.insuranceFee = insuranceFee;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    @Override
    public double calculateStorageCost() {
        return getPrice() * 0.10 + insuranceFee;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", страховка: %.2f", insuranceFee);
    }
}