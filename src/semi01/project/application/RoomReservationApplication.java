package semi01.project.application;

import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SweetRoomResrvation;
import semi01.project.TwinRoomReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomReservationApplication {
    private static ArrayList<RoomReservation> reservationList = new ArrayList<RoomReservation>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            int select;
            System.out.println("===호텔 예약 프로그램을 시작합니다.===");
            System.out.println("1. 예약 | 2. 모든 룸의 정보 보기 | 3. 모든 고객의 예약 정보 보기 | " +
                    "4. 특정 고객의 예약 정보 보기 | 5. 프로그램 종료");
            System.out.print("선택 > ");
            select = scanner.nextInt();
            switch (select) {
                case 1: startReservation(); break;
                case 2: showAllRoom(); break;
                case 3: showAllReservation(); break;
                case 4:
                    System.out.println("예약자명을 입력해주세요.");
                    System.out.print("예약자명: ");
                    String name = scanner.next();
                    RoomReservation findName = findReservation(name);
                    if(findName == null) {
                        System.out.println("예약되지 않았습니다.");
                        break;
                    } else {
                        findName.showRoomInfo();
                        break;
                    }
                case 5: run = false; break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주십시오.");
                    break;
            }


        }
        System.out.println("프로그램 종료");
    }
    //예약자 명으로 예약 정보 보기
    public static RoomReservation findReservation(String customerName) {
        RoomReservation result = null;
        for(RoomReservation reserve : reservationList) {
            if(reserve.getCustomerName().equals(customerName)) {
                result = reserve;
                break;
            }
        }
        return result;
    }
    public static void showMoney(RoomReservation roomReservation) {
        System.out.print("예약 후 지불해야할 금액: ");
        int price = roomReservation.calcPrice(roomReservation.getDate());
        System.out.println(price);
        System.out.print("예약 내역: ");
        roomReservation.showRoomInfo();
    }

    public static void startReservation() {
        System.out.print("예약자명: ");
        String customerName = scanner.next();
        System.out.print("예약 일수: ");
        int date = scanner.nextInt();
        System.out.print("예약할 룸: ");
        String roomName = scanner.next();
        RoomReservation reserve = null;
        //룸에 따라서 객체 생성
        switch (roomName) {
            case "single":
                reserve = new RoomReservation(customerName, date);
                break;
            case "double":
                reserve = new DoubleRoomReservation(customerName, date);
                break;
            case "twin":
                reserve = new TwinRoomReservation(customerName, date);
                break;
            case "sweet":
                reserve = new SweetRoomResrvation(customerName, date);
                break;
            default:
                System.out.println("방을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
                break;
        }
        System.out.print("예약 인원: ");
        int person = scanner.nextInt();
        if(reserve.getPersonLimit() >= person) {
            reservationList.add(reserve);
            showMoney(reserve);

        } else {
            System.out.println("인원제한(" + reserve.getPersonLimit() + "명)에 걸렸습니다. 처음으로 돌아갑니다.");
        }

    }

    public static void showAllRoom() {
        RoomReservation room = new RoomReservation();
        room.showInfo();
        room = new DoubleRoomReservation();
        room.showInfo();
        room = new TwinRoomReservation();
        room.showInfo();
        room = new SweetRoomResrvation();
        room.showInfo();
    }
    public static void showAllReservation() {
        for(RoomReservation room: reservationList) {
            room.showRoomInfo();
        }
    }
}
