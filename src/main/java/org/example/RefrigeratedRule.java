package org.example;

public class RefrigeratedRule implements StorageRule {
    @Override
    public boolean checkStorage(Product product) {
        return product instanceof PerishableProduct;
    }
}