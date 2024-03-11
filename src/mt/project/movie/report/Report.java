package mt.project.movie.report;

import mt.project.movie.Db;

public class Report<T> {
    Db db = Db.getInstance();

    public static final String TITLE = "\n";
    public static final String HEADER = "\n";
    public static final String LINE = "------------------------------\n";

    protected StringBuffer buffer;

    public String getReport(){
        return buffer.toString();
    };

    public void makeHeader(){
        buffer.append(MovieReport.LINE);
        buffer.append(MovieReport.TITLE);
        buffer.append(MovieReport.HEADER);
        buffer.append(MovieReport.LINE);
    };

    public void makeBody(T t){};
    public void makeFooter() {
        buffer.append(MovieReport.LINE);
    }
}
