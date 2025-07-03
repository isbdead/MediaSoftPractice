import java.util.*;
import java.util.stream.Collectors;

public class CarAnalysis {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 25000, 30000));
        cars.add(new Car("Honda", "Civic", 22000, 45000));
        cars.add(new Car("BMW", "X5", 60000, 10000));
        cars.add(new Car("Mercedes-Benz", "C-Class", 50000, 20000));
        cars.add(new Car("Toyota", "Corolla", 18000, 60000));

        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .collect(Collectors.toList());

        List<Car> sortedCars = filteredCars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .collect(Collectors.toList());

        List<Car> top3Expensive = sortedCars.subList(0, Math.min(3, sortedCars.size()));

        double averageMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);

        Map<String, List<Car>> groupedByManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Машины с пробегом меньше 50,000 км: " + filteredCars);
        System.out.println("Топ-3 самые дорогие машины: " + top3Expensive);
        System.out.println("Средний пробег: " + averageMileage);
        System.out.println("Машины сгруппированные по производителю: " + groupedByManufacturer);
    }

    public static class Car {
        private String manufacturer;
        private String model;
        private double price;
        private int mileage;

        public Car(String manufacturer, String model, double price, int mileage) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.price = price;
            this.mileage = mileage;
        }

        public String getManufacturer() { return manufacturer; }
        public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getMileage() { return mileage; }
        public void setMileage(int mileage) { this.mileage = mileage; }


        @Override
        public String toString() {
            return "Автомобиль{" +
                    "Производитель='" + manufacturer + '\'' +
                    ", Модель='" + model + '\'' +
                    ", Цена=" + price +
                    ", Пробег=" + mileage +
                    '}';
        }
    }
}
