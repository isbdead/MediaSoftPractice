import java.util.*;

public class Car implements Comparable<Car> {

    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private double mileage;
    private double price;

    public Car(String vin, String model, String manufacturer, int year, double mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    // Переопределение equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        return Objects.equals(vin, other.vin); // Сравниваем VIN
    }

    // Переопределение hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(vin); // Используем VIN для вычисления хеш-кода
    }

    // Реализация Comparable<Car> (сортировка по году выпуска)
    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.year); // Сортируем от новых к старым
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        // Создание нескольких машин, включая дубликаты по VIN
        Car car1 = new Car("VIN001", "Toyota Camry", "Toyota", 2020, 50000.0, 25000.0);
        Car car2 = new Car("VIN002", "BMW X5", "BMW", 2022, 20000.0, 45000.0);
        Car car3 = new Car("VIN001", "Toyota Camry", "Toyota", 2021, 60000.0, 27000.0); // Дубликат VIN
        Car car4 = new Car("VIN003", "Mercedes-Benz C-Class", "Mercedes-Benz", 2018, 80000.0, 35000.0);

        // Добавление машин в HashSet (дубликаты по VIN не должны добавляться)
        HashSet<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3); // Этот дубликат не будет добавлен
        carSet.add(car4);

        System.out.println("Количество машин в HashSet: " + carSet.size());  // Должно быть 3

        // Сортировка машин по году выпуска (от новых к старым)
        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        System.out.println("\nМашины, отсортированные по году выпуска:");
        for (Car car : sortedCars) {
            System.out.println(car);
        }
    }
}
