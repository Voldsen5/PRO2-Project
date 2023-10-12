package studentapplication.controller;

import studentapplication.model.Student;

import java.util.List;

public interface Storage {
    List<Student> getStudents();
    void storeStudent(Student student);
    void deleteStudent(Student student);
}
