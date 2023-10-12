package storage;

import model.Student;
import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private Storage storage;

    @BeforeEach
    public void setUp() {
        storage = new Storage();
    }

    @Test
    public void addTeamToEmptyStorage() {
        //arrange
        Team team = new Team("A", "1");
        // act
        storage.addTeam(team);
        // assert
        Set<Team> expected = new HashSet<>();
        expected.add(team);
        assertEquals(expected, storage.getAllTeams());
    }

    @Test
    public void addTeamToNotEmptyStorage() {
        // arrange
        Team teamA = new Team("A", "1");
        storage.addTeam(teamA);
        Team teamB = new Team("B", "2");
        // act
        storage.addTeam(teamB);
        // assert
        Set<Team> expected = new HashSet<>();
        expected.add(teamA);
        expected.add(teamB);
        assertEquals(expected, storage.getAllTeams());
    }

    @Test
    public void addStudentToEmptyStorage() {
        // arrange
        Student s1 = new Student("Hans", 22);
        // act
        storage.addStudent(s1);
        // assert
        Set<Student> expected = new HashSet<>();
        expected.add(s1);
        assertEquals(expected, storage.getAllStudents());
    }

    @Test
    public void addStudentToNotEmptyStorage() {
        // arrange
        Student s1 = new Student("Hans", 22);
        storage.addStudent(s1);
        Student s2 = new Student("Ib", 20);
        // act
        storage.addStudent(s2);
        // assert
        Set<Student> expected = new HashSet<>();
        expected.add(s1);
        expected.add(s2);
        assertEquals(expected, storage.getAllStudents());
    }
}