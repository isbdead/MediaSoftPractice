public class LuxRoomServiceImpl<T extends LuxRoom> implements LuxRoomService<T> {

    @Override
    public void clean(T room) {
        System.out.println("Люкс-комната " + room.getNumber_room() + " была убрана.");
    }

    @Override
    public void reserve(T room) {
        if (room.isBooked()) {
            throw new RoomAlreadyReservedExc("Люкс-комната " + room.getNumber_room() + " уже забронирована!");
        }
        room.setBooked(true);
        System.out.println("Люкс-комната " + room.getNumber_room() + " успешно забронирована.");
    }

    @Override
    public void free(T room) {
        room.setBooked(false);
        System.out.println("Люкс-комната " + room.getNumber_room() + " освобождена.");
    }

    @Override
    public void foodDelivery(T room) {
        System.out.println("Еда доставлена в люкс-комнату " + room.getNumber_room());
    }
}
