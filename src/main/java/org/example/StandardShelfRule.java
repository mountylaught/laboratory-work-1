package org.example;

public class StandardShelfRule implements StorageRule {
    @Override
    public boolean checkStorage(Product product) {

        if (product instanceof PerishableProduct) {
            return false;
        }
        return true;
    }
}