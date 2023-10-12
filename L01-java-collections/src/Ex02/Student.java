package Ex02;

import java.util.ArrayList;

public class Student {
    private final int StudentNo;
    private String name;
    private final ArrayList<Integer> grades;
    College college;

    public Student (int studentNo, String name, ArrayList<Integer> grades){
        this.StudentNo = studentNo;
        this.name = name;
        this.grades = grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getGrade() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade){
        this.grades.add(grade);
    }

    public int getStudentNo() {
        return StudentNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student:\n" +
                "StudentNo: " + StudentNo + "\n" +
                "Name: '" + name + "'\n" +
                "Grade: " + grades + "\n" +
                "College: " + college;
    }

    public double averageGradeForStudent(){
        double average = 0;
        for (int i = 0; i < getGrade().size(); i++) {
            average += this.grades.get(i);
        }
        return average;
    }
}

