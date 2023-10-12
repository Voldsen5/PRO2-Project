package demopersist;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadPerson {

    public static void main(String[] args) {
        String filename = "L15 Architecture - Serializable/src/demopersist/Person.ser";
        try (FileInputStream f_in = new FileInputStream(filename);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            Person p = (Person) obj;
            System.out.println("Person er hentet: " + p);
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
    }
}
