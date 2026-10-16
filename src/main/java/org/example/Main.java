package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ЛАБОРАТОРНОЙ РАБОТЫ №2 ===\n");

        // 1. Создаем габариты (Композиция)
        Dimensions dimStandard = new Dimensions(2.5, 15.0, false);
        Dimensions dimFragile = new Dimensions(1.0, 5.0, true);

        // 2. Создаем разные виды товаров (Наследование от абстрактного Product)
        Product regularProduct = new PerishableProduct("ART-001", "Молоко", 80.0, 20, 5, dimStandard, 5);
        Product fragileProduct = new FragileProduct("ART-002", "Ваза хрустальная", 6000.0, 5, 1, dimFragile, 500.0);
        Product bulkProduct = new BulkProduct("ART-003", "Сахар (песок)", 70.0, 100, 10, dimStandard, 1.0);

        // Проверяем работу абстрактного метода calculateStorageCost() для каждого наследника
        System.out.println("--- Расчет стоимости хранения (абстрактный метод) ---");
        System.out.println(regularProduct + " | Стоимость хранения: " + regularProduct.calculateStorageCost());
        System.out.println(fragileProduct + " | Стоимость хранения: " + fragileProduct.calculateStorageCost());
        System.out.println(bulkProduct + " | Стоимость хранения: " + bulkProduct.calculateStorageCost());

        // 3. Создаем склад (Агрегация)
        Warehouse warehouse = new Warehouse(5);

        // 4. Создаем правила хранения (Интерфейс StorageRule и полиморфизм)
        StorageRule shelfRule = new StandardShelfRule();
        StorageRule fridgeRule = new RefrigeratedRule();
        StorageRule safeRule = new SafeBoxRule();

        System.out.println("\n--- Проверка правил размещения на складе (Интерфейсы) ---");

        // Пытаемся положить молоко в холодильник (должно пройти успешно)
        System.out.println("Размещаем молоко в холодильник:");
        warehouse.addProductWithRule(regularProduct, fridgeRule);

        // Пытаемся положить хрустальную вазу на обычную полку (обычная полка откажет для хрупкого/дорогого)
        System.out.println("\nРазмещаем хрупкую вазу на стандартную полку:");
        warehouse.addProductWithRule(fragileProduct, shelfRule);

        // Помещаем хрупкую вазу в сейф (должно пройти успешно)
        System.out.println("\nРазмещаем хрупкую вазу в сейф:");
        warehouse.addProductWithRule(fragileProduct, safeRule);

        // Помещаем весовой товар на стандартную полку
        System.out.println("\nРазмещаем сахар на стандартную полку:");
        warehouse.addProductWithRule(bulkProduct, shelfRule);

        // 5. Проверка того, что склад возвращает копию массива (защитное копирование из ЛР1)
        System.out.println("\n--- Проверка защитного копирования хранилища ---");
        Product[] exportedProducts = warehouse.getProducts();
        System.out.println("Товаров в полученном извне массиве: " + exportedProducts.length);
    }
}