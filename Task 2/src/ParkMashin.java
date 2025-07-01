import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ParkMashin {

    public static void main(String[] args) {
        int[] years = new int[50];
        Random random = new Random();
        for (int i = 0; i < years.length; i++) {
            years[i] = random.nextInt(2026 - 2000) + 2000;
        }

        System.out.println("Машины, выпущенные после 2015 года:");
        List<Integer> machinesAfter2015 = new ArrayList<>();
        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
                machinesAfter2015.add(year);
            }
        }
        System.out.println();

        if (machinesAfter2015.isEmpty()) {
            System.out.println("Нет машин, выпущенных после 2015 года.");
        } else {
            double sum = 0;
            for (int year : machinesAfter2015) {
                sum += (2025 - year); 
            }
            double averageAge = sum / machinesAfter2015.size();
            System.out.println("Средний возраст машин, выпущенных после 2015 года: " + averageAge);
        }
    }
}
