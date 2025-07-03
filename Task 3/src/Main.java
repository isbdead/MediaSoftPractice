public class Main {
    public static void main(String[] args) {
        RoomService<StandardRoom> service1 = new SimpleRoomService<>();
        StandardRoom standard = new StandardRoom(101);
        service1.clean(standard);
        service1.reserve(standard);
        service1.free(standard);

        System.out.println();

        LuxRoomService<UltraLuxRoom> luxService = new LuxRoomServiceImpl<>();
        UltraLuxRoom ultra = new UltraLuxRoom(202);
        luxService.clean(ultra);
        luxService.reserve(ultra);
        luxService.foodDelivery(ultra);
        luxService.free(ultra);

        System.out.println();

        // попытка зарезервировать уже забронированную комнату
        try {
            service1.reserve(standard);
            service1.reserve(standard);
        } catch (RoomAlreadyReservedExc ex) {
            System.out.println("ошибка: " + ex.getMessage());
        }

    }
}
