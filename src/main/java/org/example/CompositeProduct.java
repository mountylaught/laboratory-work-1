package org.example;

public class CompositeProduct {
    private final String articul;
    private final String name;
    private final double price;
    private final int quantity;

    private final Dimensions dimensions;
    private final StorageRule storageRule;
    private final CalculationStrategy calcStrategy;

    public CompositeProduct(String articul, String name, double price, int quantity,
                            Dimensions dimensions, StorageRule storageRule,
                            CalculationStrategy calcStrategy) {
        if (articul == null || articul.isEmpty()) {
            throw new IllegalArgumentException("Артикул не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть > 0");
        }
        if (dimensions == null || storageRule == null || calcStrategy == null) {
            throw new IllegalArgumentException("Компоненты товара не могут быть null");
        }

        this.articul = articul;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dimensions = dimensions;
        this.storageRule = storageRule;
        this.calcStrategy = calcStrategy;
    }

    public double getStorageCost() {
        return calcStrategy.calculateStorageCost(price, quantity);
    }

    public boolean canBeStoredWith(StorageRule rule) {
        return this.storageRule.equals(rule);
    }

    public String getArticul() { return articul; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Dimensions getDimensions() { return dimensions; }
    public StorageRule getStorageRule() { return storageRule; }

    @Override
    public String toString() {
        return String.format("CompositeProduct [%s] '%s': цена=%.2f, хрупкий=%s",
                articul, name, price, dimensions.isFragile());
    }
}