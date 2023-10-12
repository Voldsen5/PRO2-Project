package modelstudent;

import model.Student;
import model.Team;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    public void constructTeam() {
        // arrange
        // act
        Team team = new Team("Great Boys", "Room B");
        //assert
        assertEquals("Great Boys", team.getName());
        assertEquals("Room B", team.getRoom());
        assertEquals(0, team.getNumberOfStudents());
        assertNotNull(team.getStudents());
    }

    @Test
    void addStudent() {
        // arrange
        Team team = new Team("Great Boys", "Room B");
        Student s1 = new Student("Jane Jensen", 21);
        Student s2 = new Student("Lene Hansen", 22);
        Student s3 = new Student("Mette Nielsen", 20);
        // act
        team.addStudent(s1);
        team.addStudent(s2);
        team.addStudent(s3);
        // assert
        assertTrue(Arrays.asList(team.getStudents()).contains(s1));
        assertTrue(Arrays.asList(team.getStudents()).contains(s2));
        assertTrue(Arrays.asList(team.getStudents()).contains(s3));
        assertEquals(3, team.getNumberOfStudents());
    }
}