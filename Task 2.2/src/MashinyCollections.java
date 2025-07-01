import java.util.*;

public class MashinyCollections {

    public static void main(String[] args) {
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

        Set<String> uniqueModels = new HashSet<>(models);
        List<String> sortedModels = new ArrayList<>(uniqueModels);
        Collections.sort(sortedModels, Collections.reverseOrder());

        System.out.println("Модели машин (без дубликатов, отсортированные в обратном алфавитном порядке):");
        for (String model : sortedModels) {
            System.out.print(model + " ");
        }
        System.out.println();

        Set<String> modelsSet = new HashSet<>(sortedModels);

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
