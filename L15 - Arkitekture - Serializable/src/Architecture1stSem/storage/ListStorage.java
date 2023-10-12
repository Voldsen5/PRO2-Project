package Architecture1stSem.storage;

import Architecture1stSem.model.Company;
import Architecture1stSem.model.Employee;
import studentapplication.controller.Storage;
import studentapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage {
    private static final List<Company> companies = new ArrayList<>();
    private static final List<Employee> employees = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static List<Company> getCompanies() {
        return new ArrayList<>(companies);
    }

    public static void storeCompany(Company company) {
        companies.add(company);
    }

    public static void deleteCompany(Company company) {
        companies.remove(company);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public static void storeEmployee(Employee employee) {
        employees.add(employee);
    }

    public static void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public void storeStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }
}
