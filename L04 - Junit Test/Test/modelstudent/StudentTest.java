package modelstudent;

import model.Student;
import model.TooManyGradesException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void constructStudent() {
        // arrange
        // act
        Student student = new Student("Jane Jensen", 22);
        // assert
        assertEquals("Jane Jensen", student.getName());
        assertEquals(22, student.getAge());
        assertEquals(new ArrayList<Integer>(), student.getGrades());
    }

    @Test
    public void addGrade() {
        // arrange
        Student student = new Student("Jane Jensen", 22);
        // act
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        // assert
        List<Integer> expected = new ArrayList<>(List.of(7, 12, 2));
        assertEquals(expected, student.getGrades());
    }

    @Test
    public void addGradeThrowsException() {
        // arrange
        Student student = new Student("Jane Jensen", 22);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        student.addGrade(7);
        // act & assert
        Exception exception = assertThrows(TooManyGradesException.class,
                () -> student.addGrade(12));
        assertEquals(exception.getMessage(), "For mange karakterer givet");
    }

    @Test
    void averageGrade() {
        // arrange
        Student student = new Student("Jane Jensen", 22);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        // act
        double actualResult = student.averageGrade();
        // assert
        assertEquals(7.0, actualResult, 0.0001);
    }
}
