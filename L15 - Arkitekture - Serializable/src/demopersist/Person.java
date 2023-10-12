package demopersist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private final List<Integer> grades;

    public Person(String name) {
        grades = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + grades;
    }

    public int numberOfGrades() {
        return grades.size();
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
}
