package semi01.project;

public class TwinRoomReservation extends RoomReservation {
    double saleRatio;

    public TwinRoomReservation() {
        this.roomName = "twin";
        this.saleRatio = 0.1;
        this.price = 25;
        this.personLimit = 3;
    }
    public TwinRoomReservation(String customerName, int date) {
        super(customerName, date);
        this.roomName = "twin";
        this.saleRatio = 0.1;
        this.price = 25;
        this.personLimit = 3;
    }

    @Override
    public int calcPrice(int date) {
        return date*this.price - (int)(date*this.price*this.saleRatio);
    }
}
