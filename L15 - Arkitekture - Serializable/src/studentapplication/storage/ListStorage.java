package studentapplication.storage;

import studentapplication.controller.Storage;
import studentapplication.model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage, Serializable {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<Student>(students);
    }

    public void storeStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    // -------------------------------------------------------------------------

    public static ListStorage loadStorage() {
        String fileName = "L15 Architecture - Serializable/src/studentapplication/storage.ser";
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)
        ) {
            Object obj = objIn.readObject();
            ListStorage storage = (ListStorage) obj;
            System.out.println("Storage loaded from file " + fileName);
            return storage;
        } catch (ClassCastException ex) {
            System.out.println("Class of serialized object changed");
            System.out.println(ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class of serialized object not found");
            System.out.println(ex);
            return null;
        } catch (IOException ex) {
            System.out.println("Error reading file");
            System.out.println(ex);
            return null;
        }
    }

    public static void saveStorage(Storage storage) {
        String fileName = "L15 Architecture - Serializable/src/studentapplication/storage.ser";
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)
        ) {
            objOut.writeObject(storage);
            System.out.println("Storage saved in file " + fileName);
        } catch (IOException ex) {
            System.out.println("Error writing file");
            System.out.println(ex);
            throw new RuntimeException();
        }
    }
}
