package org.example;

public class SafeBoxRule implements StorageRule {
    @Override
    public boolean checkStorage(Product product) {
        boolean isFragile = (product instanceof FragileProduct);
        boolean isExpensive = product.getPrice() > 5000.0;
        return isFragile || isExpensive;
    }
}