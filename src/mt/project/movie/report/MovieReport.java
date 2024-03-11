package mt.project.movie.report;
import mt.project.movie.Movie;
import java.util.ArrayList;

public class MovieReport extends Report<Movie> {

    public static final String TITLE = "현재 상영중인 영화 목록\n";
    public static final String HEADER = "영화ID | 영화 | 평점 | 시청자\n";

    @Override
    public String getReport() {
        buffer = new StringBuffer();
        ArrayList<Movie> movieList = db.getMovieList(); // 영화 목록
        makeHeader();
        for (Movie movie : movieList) {
            makeBody(movie);
        }
        makeFooter();
        return buffer.toString();
    }

    @Override
    public void makeBody(Movie movie) {
        buffer.append(movie.getMovieId()).append(" | ");
        buffer.append(movie.getMovieName()); // 영화 이름
        buffer.append(" | " + Math.round(movie.showRate(movie))); // 영화 평점
        buffer.append(" | ");
        buffer.append(movie.getUserList().size()).append("명");
        buffer.append("\n");
    }
}