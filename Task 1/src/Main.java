public class Main {

    public static void main(String[] args) {
        BankAccount client1 = new BankAccount("Ермолай Артёмович Тойво");
        BankAccount client2 = new BankAccount("Василий Геннадьевич Шпага");

        client1.deposit(500);
        //client1.displayInfo();

        //client2.withdraw(1000);
        //client2.displayInfo();

        client1.transfer(client2,500);
        client1.displayInfo();
        client2.displayInfo();

        System.out.println("client1.Совпадает с (client2)? " + client1.equals(client2));
    }
}
