public class Person {
    @JsonField(name = "first_name")
    private String name;

    @JsonField(name = "age_years")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
