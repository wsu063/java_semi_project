package mt.project.application;

import mt.project.movie.*;
import mt.project.movie.report.Report;
import mt.project.movie.report.MovieReport;
import mt.project.movie.report.UserReport;
import mt.project.util.Define;

import java.util.Scanner;

public class MTApplication {

    Db db = Db.getInstance(); // 영화 DB 생성
    // 영화관 생성
    Theater theater;
    // 유저 생성
    User user;
    Movie movie;
    Rate rate;
    static Report report;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MTApplication app = new MTApplication();
        app.registerMovie();
        app.registerUser(); // 고객 등록
        app.watchMovie(); // 사전 등록된 고객이 영화 시청
        boolean run = true;
        while (run) {
            String show = "";
            System.out.println("MovieTheater에 오신것을 환영합니다.");
            System.out.println("원하시는 메뉴를 선택해주세요.");
            System.out.println("1.현재 상영중인 영화 목록 | 2. 시청자 목록 | 3.영화의 시청자 목록 | 4. 영화 추가 | 5. 시청자 추가 | " +
                    "6. 새로 시청한 영화 평점 입력 | 7. 프로그램 종료");
            System.out.print("선택 > ");
            String select = scanner.next();
            switch (select) {
                case "1": //현재 상영중인 영화 목록
                    report = new MovieReport();
                    show = app.report.getReport();
                    System.out.println(show);
                    break;
                case "2": //영화 시청자 목록
                    report = new UserReport();
                    show = app.report.getReport();
                    System.out.println(show);
                    break;
                case "3": // 한 영화의 시청자 목록
                    app.showUser();
                    break;
                case "4": // 영화 추가
                    app.addMovie();
                    break;
                case "5": // 시청자 추가
                    app.addUser();
                    break;
                case "6": // 영화 시청
                    app.rateMovie();
                    break;
                case "7": // 프로그램 종료
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println("프로그램이 종료되었습니다.");
    }

    public void addMovie() {
        System.out.print("추가하고자 하는 영화 이름 > ");
        String movieName = scanner.next();
        movie = new Movie(movieName, db.getMovieList().size());
        db.addMovie(movie);
        System.out.println("추가되었습니다.");
    }

    public void addUser() {
        System.out.print("추가하고자 하는 시청자 이름 > ");
        String userName = scanner.next();
        user = new User(userName, db.getUserList().size());
        db.addUser(user);
        System.out.println("추가되었습니다.");
    }
    public void showUser() {
        while(true) {
            System.out.print("찾고자 하는 영화의 ID > ");
            int movieId = scanner.nextInt();
            movie = db.findMovie(movieId);
            if (movie == null) {
                System.out.print("존재하지 않는 Id입니다. 다시 입력해 주십시오. > ");
                movieId = scanner.nextInt();
                movie = db.findMovie(movieId);
                break;
            }
            for(User user: movie.getUserList()) {
                System.out.println(user.getUserId() + " | " + user.getUserName());
            }
            break;
        }
    }
    public void rateMovie() {
        while(true) {
            System.out.print("영화를 시청한 시청자 ID > ");
            int userId = scanner.nextInt();
            user = db.findUser(userId);
            if (user == null) {
                System.out.print("존재하지 않는 Id입니다. 다시 입력해 주십시오. > ");
                userId = scanner.nextInt();
                user = db.findUser(userId);
            }
            System.out.print("시청한 영화 ID > ");
            int movieId = scanner.nextInt();
            movie = db.findMovie(movieId);
            if (movie == null) {
                System.out.print("존재하지 않는 Id입니다. 다시 입력해 주십시오. > ");
                movieId = scanner.nextInt();
                movie = db.findMovie(movieId);
                break;
            }
            System.out.print(user.getUserName() + "님이 시청한 " + movie.getMovieName() + "의 평점을 " +
                    "입력해주세요. (평점: 1 ~ 10 ) > ");
            int rated = scanner.nextInt();
            if(rated > 10 || rated < 1) {
                System.out.print("잘못된 값입니다. 다시 입력해 주십시오. > ");
                rated = scanner.nextInt();
                break;
            }
            rate = new Rate(userId, movie, rated);
            movie.rate(rate);
            movie.addUser(user);
            user.rate(rate);
            user.watch(movie);
            break;
        }
        System.out.println("평점 입력 완료되었습니다.");
    }

    public void registerUser() {
        for (int i = 0; i < Define.USERLIST.length; i++) {
            user = new User(Define.USERLIST[i], i);
            db.addUser(user);
        }
    }

    public void registerMovie() {
        for (int i = 0; i < Define.MOVIELIST.length; i++) {
            movie = new Movie(Define.MOVIELIST[i], i);
            db.addMovie(movie); // Db에 영화 등록
        }
    }

    public void watchMovie() {
        for (Movie movie : db.getMovieList()) {
            for (User user : db.getUserList()) {
                user.watchRate(movie, 10, user);
            }
        }
    }
}
