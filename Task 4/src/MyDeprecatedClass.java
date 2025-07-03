@DeprecatedEx(message = "Используйте NewClass вместо MyDeprecatedClass")
class MyDeprecatedClass {

    @DeprecatedEx(message = "Используйте newMethod() вместо oldMethod()")
    public void oldMethod() {
        System.out.println("Old method");
    }

    public void newMethod() {
        System.out.println("New method");
    }
}
