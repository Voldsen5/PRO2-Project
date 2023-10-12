package demopersist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadAndPersistPerson {

    public static void main(String[] args) {
        Person person = null;

        String filename = "L15 Architecture - Serializable/src/demopersist/Person.ser";
        try (FileInputStream f_in = new FileInputStream(filename);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            person = (Person) obj;
            System.out.println("Person er hentet: " + person);
        } catch (ClassCastException ex) {
            System.out.println("Class of serialized object changed");
            System.out.println(ex);
            return;
        } catch (IOException ex) {
            System.out.println("Error reading file");
            System.out.println(ex);
            return;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class of serialized object not found");
            System.out.println(ex);
            return;
        }

        person.addGrade(4);
        person.addGrade(7);

        try (FileOutputStream f_out = new FileOutputStream(filename);
             ObjectOutputStream obj_out = new ObjectOutputStream(f_out)
        ) {
            obj_out.writeObject(person);
            System.out.println("Person er gemt: " + person);
        } catch (IOException ex) {
            System.out.println("Error writing file");
            System.out.println(ex);
        }
    }
}
