package studentapplication.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private boolean active;
    private int age;

    public Student(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /** Increase this student's age by one. */
    public void increaseAge() {
        age++;
    }

    @Override
    public String toString() {
        return "Navn: " + name + ", Alder: " + age + ", Aktiv: " + active;
    }
}
