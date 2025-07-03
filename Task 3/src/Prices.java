public enum Prices {
    ECONOMY(1000),
    PROROOM(2000),
    STANDARD(3000),
    LUX(4000),
    ULTRALUX(5000);

    private final int price;

    Prices(int price) {
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
