import java.util.function.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        // 1. Лямбда выражение для интерфейса Printable
        System.out.println("1. Printable:");
        Printable printable = () -> System.out.println("Печать с использованием лямбда!");
        printable.print();

        // 2. Проверка пустой строки с Predicate
        System.out.println("\n2. Predicate для строки:");
        Predicate<String> isNotNull = str -> str != null;
        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        Predicate<String> isValid = isNotNull.and(isNotEmpty);

        String str1 = "Hello";
        String str2 = null;
        String str3 = "";

        System.out.println("Строка 'Hello' валидна: " + isValid.test(str1)); // true
        System.out.println("Строка null валидна: " + isValid.test(str2));    // false
        System.out.println("Строка '' валидна: " + isValid.test(str3));      // false

        // 3. Проверка строки начинается с "J" или "N", заканчивается на "A"
        System.out.println("\n3. Проверка строки:");
        Predicate<String> startsWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> endsWithA = s -> s.endsWith("A");
        Predicate<String> complexCheck = startsWithJorN.and(endsWithA);

        String word = "Java";
        System.out.println("Строка '" + word + "' проходит проверку: " + complexCheck.test(word)); // true

        // 4. HeavyBox с Consumer и andThen
        System.out.println("\n4. Consumer для HeavyBox:");
        Consumer<HeavyBox> load = box -> System.out.println("Отгрузили ящик с весом " + box.weight);
        Consumer<HeavyBox> send = box -> System.out.println("Отправляем ящик с весом " + box.weight);
        Consumer<HeavyBox> combined = load.andThen(send);

        HeavyBox box = new HeavyBox(25);
        combined.accept(box);

        // 5. Function для описания числа
        System.out.println("\n5. Function:");
        Function<Integer, String> checkNumber = num -> {
            if (num > 0) return "Положительное число";
            if (num < 0) return "Отрицательное число";
            return "Ноль";
        };

        System.out.println("Число -10: " + checkNumber.apply(-10));
        System.out.println("Число 0: " + checkNumber.apply(0));
        System.out.println("Число 42: " + checkNumber.apply(42));

        // 6. Supplier для генерации случайного числа
        System.out.println("\n6. Supplier:");
        Supplier<Integer> random = () -> new Random().nextInt(11); // от 0 до 10 включительно
        System.out.println("Случайное число: " + random.get());

        // 7. Обработка аннотации @DeprecatedEx
        System.out.println("\n7. Обработка аннотации @DeprecatedEx:");
        AnnotationProcessor.process(MyDeprecatedClass.class);

        // 8. Json-сериализация с @JsonField
        System.out.println("\n8. Сериализация в JSON:");
        Person person = new Person("Иван", 30);
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}
