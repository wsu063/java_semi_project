package mt.project.movie;

import java.util.ArrayList;

public class User {
    //고객이름, 고객번호, 시청목록(영화), 평가목록(평가)
    private String userName;
    private int userId;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Rate> rateList = new ArrayList<>();

    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public void watch(Movie movie) {// 영화시청
        movieList.add(movie);
    }

    public void rate(Rate rate) {// 영화평가
        rateList.add(rate);
    }

    public void watchRate(Movie movie, int point) {// 영화시청 + 평가
        watch(movie);
        Rate rate = new Rate(this.userId, movie, point);
        rate(rate);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(ArrayList<Rate> rateList) {
        this.rateList = rateList;
    }
}
