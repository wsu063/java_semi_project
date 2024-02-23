package semi01.project;

public class RoomReservation {
    protected String customerName;
    protected String roomName;
    protected int date;
    protected int price;
    protected int personLimit;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public RoomReservation() {
        initRoom();
    }

    public RoomReservation(String customerName, int date) {
        initRoom();
        this.customerName = customerName;
        this.date = date;

    }
    private void initRoom() {
        this.roomName = "single";
        this.personLimit = 1;
        this.price = 10;
    }

    public int getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(int personLimit) {
        this.personLimit = personLimit;
    }

    // 예약 후 지불해야할 금액
    public int calcPrice(int date) {
        return date*this.price;
    }
    //룸 예약 정보
    public void showRoomInfo() {
        System.out.println(this.roomName + "\t" + this.date + "\t");
    }
    public void showInfo() {
        System.out.println(this.roomName + "\t" + this.price + "만원\t" + this.personLimit + "명");
    }

}
