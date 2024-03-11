package mt.project.movie;

import java.util.ArrayList;

public class Movie {
    //영화 이름, 영화번호, 상영관리스트, 관객리스트, 평점리스트
    private String movieName;
    private int movieId;
    private ArrayList<Theater> theaterList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Rate> rateList = new ArrayList<>();

    public Movie(String movieName, int movieId) {
        this.movieName = movieName;
        this.movieId = movieId;
    }
    public double showRate(Movie movie) {
        int sum = 0;
        for (Rate rate: rateList) {
            sum += rate.getRate();
        }
        double avg = (double)sum / rateList.size();
        return avg;
    }
    public void rate(Rate rate) {
        rateList.add(rate);
    }
    public void addUser(User user) {userList.add(user);}

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public ArrayList<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(ArrayList<Theater> theaterList) {
        this.theaterList = theaterList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(ArrayList<Rate> rateList) {
        this.rateList = rateList;
    }
}
