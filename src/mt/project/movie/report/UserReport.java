package mt.project.movie.report;
import mt.project.movie.User;
import java.util.ArrayList;

public class UserReport extends Report<User> {

    public static final String TITLE = "영화 시청자 목록\n";
    public static final String HEADER = "시청자 ID | 시청자 이름\n";

    @Override
    public String getReport() {
        buffer = new StringBuffer();
        ArrayList<User> userList = db.getUserList();
        makeHeader();
        for (User user: userList) {
            makeBody(user);
        }
        makeFooter();
        return buffer.toString();
    }

    @Override
    public void makeBody(User user) {
        buffer.append(user.getUserId()).append(" | "); // 시청자 ID
        buffer.append(user.getUserName()); // 시청자 이름
        buffer.append("\n");
    }
}
