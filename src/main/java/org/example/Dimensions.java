package org.example;

public final class Dimensions {

    private final double weight;
    private final double volume;
    private final boolean fragile;

    public Dimensions(double weight, double volume, boolean fragile) {

        if (weight <= 0 || volume <= 0) {
            throw new IllegalArgumentException("Вес и объем должны быть больше нуля");
        }

        this.weight = weight;
        this.volume = volume;
        this.fragile = fragile;
    }

    public double getWeight() { return weight; }
    public double getVolume() { return volume; }
    public boolean isFragile() { return fragile; }
}