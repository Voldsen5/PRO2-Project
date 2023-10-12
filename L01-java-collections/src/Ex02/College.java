package Ex02;

import java.util.ArrayList;

public class College {
    private final String name;
    public final ArrayList<Student> students = new ArrayList<>();

    public College(String name){
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public void removeStudents(Student student){
        students.remove(student);
    }

    public Student findStudent(int studentNo){
        for (Student s : students){
            if (s.getStudentNo() == studentNo){
                return s;
            }
            }
        return null;
    }

// 2.1--------------------------------------------------------------------------------------------

    public double calcAverage(){
        double average = 0;
        double count = 0;
        double result = 0;
        for (Student s : students){
            average += s.averageGradeForStudent();
            count += s.getGrade().size();
        }
        result = average/count;

        return result;
    }

    public String getName() {
        return name;
    }
}
