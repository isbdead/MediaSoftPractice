import java.util.*;

public class MashinyCollections {

    public static void main(String[] args) {
        // 1. Создание списка моделей машин (с дубликатами)
        List<String> models = new ArrayList<>();
        models.add("Toyota Camry");
        models.add("BMW X5");
        models.add("Mercedes-Benz C-Class");
        models.add("Honda Civic");
        models.add("Tesla Model S");
        models.add("Toyota Camry"); // Дубликат
        models.add("Lada Samara");
        models.add("Tesla Model 3");
        models.add("BMW X5"); // Дубликат

        // 2. Удаление дубликатов, сортировка и вывод на экран
        Set<String> uniqueModels = new HashSet<>(models);  // Удаляем дубликаты с помощью Set
        List<String> sortedModels = new ArrayList<>(uniqueModels); // Преобразуем в List
        Collections.sort(sortedModels, Collections.reverseOrder()); // Сортируем в обратном алфавитном порядке

        System.out.println("Модели машин (без дубликатов, отсортированные в обратном алфавитном порядке):");
        for (String model : sortedModels) {
            System.out.print(model + " ");
        }
        System.out.println();

        // 3. Сохранение в Set
        Set<String> modelsSet = new HashSet<>(sortedModels);

        // 4. Проверка и замена (если модель содержит "Tesla")
        List<String> modifiedModels = new ArrayList<>();
        for (String model : sortedModels) {
            if (model.contains("Tesla")) {
                modifiedModels.add("ELECTRO_CAR");
            } else {
                modifiedModels.add(model);
            }
        }

        System.out.println("\nМодели машин с заменой 'Tesla' на 'ELECTRO_CAR':");
        for (String model : modifiedModels) {
            System.out.print(model + " ");
        }
        System.out.println();
    }
}
