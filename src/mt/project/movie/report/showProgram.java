package mt.project.movie.report;

import mt.project.movie.Db;
import mt.project.movie.Movie;
import mt.project.movie.Theater;
import mt.project.movie.User;

import java.util.ArrayList;

public class showProgram {

    Db db = Db.getInstance();

    public static final String TITLE = "영화 목록\n";
    public static final String HEADER = "영화 | 평점 | 시청자\n";
    public static final String LINE = "------------------------------\n";

    private StringBuffer buffer = new StringBuffer(); // "";

    public String getReport() {
        ArrayList<Movie> movieList = db.getMovieList(); // 영화 목록
        makeHeader();
        //바디가 작동이 안되는중.
        //아마 movieList가 추가가 안된듯?
        for (Movie movie : movieList) {
            makeBody(movie);
        }
        makeFooter();
        return buffer.toString();
    }

    public void makeHeader() {
        buffer.append(showProgram.LINE);
//        buffer.append("\t" + db.getTheaterName() + " ");
        buffer.append(showProgram.TITLE);
        buffer.append(showProgram.HEADER);
        buffer.append(showProgram.LINE);
    }
    public void makeBody(Movie movie) {
        buffer.append("this is body");
        buffer.append(movie.getMovieName()); // 영화 이름
        buffer.append(" | " + movie.showRate(movie)); // 영화 평점
        buffer.append(" | ");
        for(User user: movie.getUserList()) {
            buffer.append(user.getUserName() + " "); // 영화 시청자
        }
        buffer.append("\n");


    }
    public void makeFooter() {
        buffer.append(showProgram.LINE);
    }
}
