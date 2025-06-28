import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    private String name;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    private String countNumber;

    public BankAccount (String name){
        this.name=name;
        this.balance=0;
        this.openingDate=LocalDateTime.now();
        this.isBlocked=false;
        this.countNumber=generateAccountNumber();
    }

    private String generateAccountNumber(){
        Random random = new Random();
        StringBuilder stringNumber = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringNumber.append(random.nextInt(10));
        }
        return stringNumber.toString();
    }

    public void displayInfo (){
        System.out.println(this);
    }

    public boolean deposit(int amount){
        if (isBlocked || amount<=0) return false;
        balance +=amount;
        return true;
    }

    public boolean withdraw(int amount){
        if (isBlocked || balance<amount || amount<=0) {
            System.out.println("Операция не выполнена");
            return false;
        }
        balance -=amount;
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount){
        if (amount>balance || amount<=0) return false;
        if (otherAccount.isBlocked || otherAccount==null || isBlocked) return false;
        balance -=amount;
        otherAccount.balance +=amount;
        return true;
    }

    @Override
    public String toString(){
        return String.format("Ваш номер счёта: %s | Ваше имя: %s | Ваш баланс: %d | Блокировка счёта: %s | Дата открытия: %s ", countNumber,name,balance,isBlocked,openingDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BankAccount)) return false;
        BankAccount other = (BankAccount) obj;
        return Objects.equals(this.countNumber, other.countNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countNumber);
    }
}
