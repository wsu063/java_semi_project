package mt.project.application;

import mt.project.movie.Db;
import mt.project.movie.Movie;
import mt.project.movie.Theater;
import mt.project.movie.User;
import mt.project.movie.report.showProgram;
import mt.project.util.Define;

public class MTApplication {
    
    Db db = Db.getInstance(); // 영화 DB 생성
    // 영화관 생성
    Theater theater;
    // 유저 생성
    User user;
    Movie movie;
    showProgram showp = new showProgram();


    public static void main(String[] args) {
        MTApplication app = new MTApplication();
//        app.openTheater(); // 영화관 개장
        for(Theater theater: app.db.getTheaterList()){
            app.registerMovie(); //영화를 상영관에 개봉
        }
        app.registerUser(); // 고객 등록
        app.watchMovie(); // 사전 등록된 고객이 영화 시청

        //어떤 고객이 어떤 영화를 봤는지 출력
        String show = "";
        for(int i = 0; i < app.db.getTheaterList().size(); i++) {
//            show = app.showp.getReport(app.db.getTheaterList().get(i));
            show = app.showp.getReport();
        }
        System.out.println(show);



    }

//    public void openTheater() {
//        for(int i = 0; i < Define.THEATERLIST.length; i++) {
//            theater = new Theater(Define.THEATERLIST[i], i);
//            db.addTheater(theater);
//        }
//    }

    public void registerUser() {
        for(int i = 0; i < Define.USERLIST.length; i++) {
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
//    public void registerMovieToTheater(Theater theater) {
//        //영화관마다 따로 영화를 등록한다.
//        for (int i = 0; i < Define.MOVIELIST.length; i++) {
//            movie = new Movie(Define.MOVIELIST[i], i);
//            theater.addMovie(movie); // Db에 영화 등록
//        }
//    }
    public void watchMovie() {
        // user[0]:

        // 테스트형 자료입력
        for (int i = 0; i < Define.MOVIELIST.length; i++) {
            for (int j = 0; j < Define.USERLIST.length; j++) {
                user.watchRate(movie,10);
            }
        }
    }
}
