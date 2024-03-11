package mt.project.movie;


import java.util.ArrayList;

// DB를 싱글톤으로 구현
public class Db {
    private static String DB_NAME = "Movie Theater DB"; // 데이터베이스 이름
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Theater> theaterList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();

    private static Db instance = null;

    private Db() {};

    public static Db getInstance() {
        if(instance == null) {
            instance = new Db();
        }
        return instance;
    }

    //영화관 개장
    public void addTheater(Theater theater) {theaterList.add(theater);}
    public void addMovie(Movie movie) {movieList.add(movie);}
    public void addUser(User user) {userList.add(user);}

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Theater> getTheaterList() {
        return theaterList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public User findUser(int userId) {
        User result = null;
        for(User user : userList) {
            if(user.getUserId() == userId){
                result = user;
                break;
            }
        }
        return result;
    }

    public Movie findMovie(int movieId) {
        Movie result = null;
        for(Movie movie : movieList) {
            if(movie.getMovieId() == movieId){
                result = movie;
                break;
            }
        }
        return result;
    }

}
