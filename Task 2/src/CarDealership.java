import java.util.*;

public class CarDealership {

    private List<Car> cars;

    public CarDealership() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }


    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();

        // Example Cars (replace with your data)
        dealership.addCar(new Car("VIN123", "Toyota Camry", "Toyota", 2020, 50000, 45000.0, CarType.SEDAN));
        dealership.addCar(new Car("VIN456", "Honda Civic", "Honda", 2021, 30000, 28000.0, CarType.SEDAN));
        dealership.addCar(new Car("VIN789", "BMW X5", "BMW", 2022, 20000, 60000.0, CarType.SUV));

        List<Car> allCars = dealership.getCars();
        System.out.println(allCars); // Print all cars in the dealership
    }


    public enum CarType {
        SEDAN, SUV, ELECTRIC, TRUCK, HATCHBACK
    }

    public static class Car {
        private String vin;
        private String model;
        private String manufacturer;
        private int year;
        private int mileage;
        private double price;
        private CarType type;

        public Car(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
            this.vin = vin;
            this.model = model;
            this.manufacturer = manufacturer;
            this.year = year;
            this.mileage = mileage;
            this.price = price;
            this.type = type;
        }

        public String getVin() { return vin; }
        public void setVin(String vin) { this.vin = vin; }

        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }

        public String getManufacturer() { return manufacturer; }
        public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

        public int getYear() { return year; }
        public void setYear(int year) { this.year = year; }

        public int getMileage() { return mileage; }
        public void setMileage(int mileage) { this.mileage = mileage; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public CarType getType() { return type; }
        public void setType(CarType type) { this.type = type; }


        @Override
        public String toString() {
            return "Автомобиль{" +
                    "VIN-код='" + vin + '\'' +
                    ", Модель='" + model + '\'' +
                    ", Производитель='" + manufacturer + '\'' +
                    ", Год выпуска=" + year +
                    ", Пробег=" + mileage +
                    ", Цена=" + price +
                    ", Тип автомобиля=" + type +
                    '}';
        }
    }
}
