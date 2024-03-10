package studentInfo.project.school;

import java.lang.reflect.Array;
import java.util.ArrayList;

//school은 싱글톤으로 구현 -> 하나의 School객체만 공유하도록 만든다
public class School {
    private static String SCHOOL_NAME = "Good School"; // 학교이름
    private ArrayList<Student> studentList = new ArrayList<>(); // 학교에 등록한 학생들
    private ArrayList<Subject> subjectList = new ArrayList<>(); // 학교에 개설된 과목
    //1. 싱글톤으로 사용할 객체를 private, static 키워드를 붙여서 선언한다.
    private static School instance = null;
    //2. 싱글톤은 생성자가 private -> 외부에서 School객체를 생성할 수 없게 만든다
    private School() {}

    //3. 싱글톤 객체를 생성하는 메소드 구현
    public static School getInstance() {
        //처음 school객체가 생성될때 실행
        if(instance == null) {
            instance = new School();
        }
        //2번째 이후 school객체가 생성될때 실행
        return instance;
    }
    //학생 입학
    public void addStudent(Student student) {
        studentList.add(student);
    }
    //과목개설
    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }

    //학생 리스트 리턴
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    //과목 리스트 리턴
    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }
}
