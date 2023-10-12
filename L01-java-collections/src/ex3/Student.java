package ex3;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private final int studentNo;
    private String name;
    private final List<Integer> grades = new ArrayList<>();

    public Student(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Student[%s, %s]", studentNo, name);
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentNo, other.studentNo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Student other) {
            return this.studentNo == other.studentNo;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studentNo;
    }

    // Inherited equals() from Object compares references.
    // Inherited hashCode() from Object return addresses (references).

    // If Set<E> (or Map<K,V>) is used, and
    // two objects in memory represents the same identity,
    // then equals() and hashCode() must be overridden in E (or K).

    // Method hasCode() must be consistent with equals(),
    // that is, a.equals(b) == true => a.hashCode() == b.hashCode().

    // Method compareTo() must be consistent with equals(),
    // that is, a.equals(b) == true <=> a.compareTo(b) == 0.
}
