package ex3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class College {
    private String name;

    // Q2.2
    // link to --> 0..* Student
    private final Set<Student> students = new LinkedHashSet<>();

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("College[%s]", name);
    }

    //-----------------------------------------------------

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    //-----------------------------------------------------

    /** Pre: At least one grade exists. */
    public double calcAverage() {
        int sum = 0;
        int count = 0;
        for (Student student : students) {
            for (int grade : student.getGrades()) {
                sum += grade;
            }
            count += student.getGrades().size();
        }
        return (double) sum / count;
    }

    /** Note: Nullable return value. */
    public Student findStudent(int studentNo) {
        for (Student student : students) {
            if (student.getStudentNo() == studentNo)
                return student;
        }
        return null;
    }

    //-----------------------------------------------------

    public boolean contains(Student student) {
        return students.contains(student);
    }
}
