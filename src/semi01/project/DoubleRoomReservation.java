package semi01.project;

public class DoubleRoomReservation extends RoomReservation{
    double saleRatio;

    public DoubleRoomReservation() {
        this.roomName = "double";
        this.saleRatio = 0.05;
        this.price = 20;
        this.personLimit = 2;
    }
    public DoubleRoomReservation(String customerName, int date) {
        super(customerName, date);
        this.roomName = "double";
        this.saleRatio = 0.05;
        this.price = 20;
        this.personLimit = 2;
    }

    @Override
    public int calcPrice(int date) {
        return date*this.price - (int)(date*this.price*this.saleRatio);
    }
}
