package mt.project.movie;

public class Rate {
    // 영화Id, 사용자, 점수
    private int userId;
    private Movie movie;
    private int rate;

    public Rate(int userId, Movie movie, int rate) {
        this.userId = userId;
        this.movie = movie;
        this.rate = rate;
    }

    @Override
    public String toString() {
        //어느 고객의 어느 영화가 몇점이다.
        return "고객번호: " + this.userId + ", " + movie.getMovieName() + ": " + this.rate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
