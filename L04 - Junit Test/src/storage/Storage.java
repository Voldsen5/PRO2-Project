package storage;

import model.Student;
import model.Team;

import java.util.HashSet;
import java.util.Set;

public class Storage {
    private final Set<Team> teams = new HashSet<>();
    private final Set<Student> students = new HashSet<>();

    public void addTeam(Team team) {
        teams.add(team);
    }
    
    public Set<Team> getAllTeams() {
        return new HashSet<>(teams);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    
    public Set<Student> getAllStudents() {
        return new HashSet<>(students);
    }
    
}
