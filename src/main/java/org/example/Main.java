package org.example;

public class Main {
    public static void main(String[] args) {
        // создаем склад вместимостью до 5 товаров
        Warehouse warehouse = new Warehouse(5);

        // добавляем товар
        Dimensions dim = new Dimensions(2.5, 15.0, false);
        Product product = new Product("art-001", "Клавиатура", 3333.0, 10, 2, dim);
        warehouse.addProduct(product);

        System.out.println("Товар добавлен: " + product);
        System.out.println("Цена с НДС (по умолчанию): " + product.priceWithTax());
        System.out.println("Цена с НДС (своя ставка 10%): " + product.priceWithTax(0.10));

        // проверка конструктора
        System.out.println("\nПроверка защиты от неверных данных:");
        try {
            Product badProduct = new Product("art-002", "Носок", -500.0, 5, 1, dim);
        } catch (IllegalArgumentException e) {

            System.out.println("Ошибка успешно поймана: " + e.getMessage());
        }

        // 3. Попытка отгрузить больше товара, чем есть на складе
        try {
            product.ship(50); // но у нас только 10
        } catch (IllegalStateException e) {
            System.out.println("Ошибка успешно поймана: " + e.getMessage());
        }
    }
}