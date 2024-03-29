package semi01.project;

public class SweetRoomResrvation extends RoomReservation{
    double saleRatio;
    boolean breakFastFree;

    public SweetRoomResrvation() {
        this.roomName = "sweet";
        this.saleRatio = 0.2;
        this.price = 50;
        this.breakFastFree = true;
        this.personLimit = Integer.MAX_VALUE; // 무한?
    }
    public SweetRoomResrvation(String customerName, int date) {
        super(customerName, date);
        this.roomName = "sweet";
        this.saleRatio = 0.2;
        this.price = 50;
        this.breakFastFree = true;
        this.personLimit = Integer.MAX_VALUE; // 무한?
    }

    @Override
    public int calcPrice(int date) {
        if(date >= 3) {
            return date*this.price - (int)(date*this.price*this.saleRatio);
        } else {
            return date*this.price;
        }
    }

    @Override
    public void showRoomInfo() {
        System.out.println(this.customerName + "님의 예약 내용: " + this.roomName + "\t" + this.date + "일\t" + "조식무료제공: " + this.breakFastFree);
    }

    @Override
    public void showInfo() {
        System.out.println(this.roomName + "\t" + this.price + "만원\t" + "조식무료제공: " + this.breakFastFree);

    }
}
