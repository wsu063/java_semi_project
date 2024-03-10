package mt.project.movie;

import java.util.ArrayList;

public class Theater {
    //영화관 이름, 영화관id, 상영리스트, 시청리스트
    private String theaterName;
    private int theaterId;
    private ArrayList<Movie> movieList = new ArrayList<>();

    public Theater(String theaterName, int theaterId) {
        this.theaterName = theaterName;
        this.theaterId = theaterId;
    }

    public void screen(Movie movie) {
        //영화관에 영화 상영
        movieList.add(movie);
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
}
