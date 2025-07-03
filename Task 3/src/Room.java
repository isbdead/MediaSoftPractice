import java.util.Random;

public abstract class Room {
    protected int number_room;
    protected int maxCount_personInRoom;
    protected int priceNight;
    protected boolean booked;

    public Room(int number_room, Prices priceEnum) {
        this.number_room = number_room;
        this.priceNight = priceEnum.getPrice();
        this.maxCount_personInRoom = new Random().nextInt(4)+1;
        this.booked = false;
    }

    public int getNumber_room() {
        return number_room;
    }

    public int getMaxCount_personInRoom() {
        return maxCount_personInRoom;
    }

    public int getPriceNight(){
        return priceNight;
    }

    public boolean isBooked(){
        return booked;
    }

    public void setBooked(boolean booked){
        this.booked = true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " №" + number_room +
                ", количество человек: " + maxCount_personInRoom +
                ", цена: " + priceNight +
                ", забронирована: " + booked;
    }

}
