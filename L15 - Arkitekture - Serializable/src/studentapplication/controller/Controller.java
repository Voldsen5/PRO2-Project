package studentapplication.controller;

import studentapplication.gui.Observer;
import studentapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {
    private static Storage storage;

    public static Storage getStorage() {
        return storage;
    }

    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    //-----------------------------------------------------

    /**
     * Create a new Student.
     * Pre: name not empty, age >= 0.
     */
    public static Student createStudent(String name, int age, boolean active) {
        Student student = new Student(name, age, active);
        storage.storeStudent(student);
        notifyObservers();
        return student;
    }

    /** Delete the student. */
    public static void deleteStudent(Student student) {
        storage.deleteStudent(student);
        notifyObservers();
    }

    /**
     * Update the student.
     * Pre: name not empty, age >= 0.
     */
    public static void updateStudent(Student student, String name, int age, boolean active) {
        student.setName(name);
        student.setAge(age);
        student.setActive(active);
    }

    //-----------------------------------------------------

    public static List<Student> getStudents() {
        return storage.getStudents();
    }

    //-----------------------------------------------------

    private static final List<Observer> observers = new ArrayList<>();

    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    private static void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
