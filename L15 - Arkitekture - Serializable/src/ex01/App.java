package ex01;

import java.io.*;

public class App {
    public static void main(String[] args) {
        MyTime time1 = new MyTime();

        time1.increase();
        time1.increase();
        time1.increase();

        System.out.println(time1.getTime());

        saveTime(time1);

        time1.increase();

        MyTime time2 = getSavedTime();

        System.out.println(time2.getTime());

        time2.increase();




    }
    public static void saveTime (MyTime time){
        String filename = "L15 - Arkitekture - Serializable/src/ex01/MyTimeFIL";
        try (FileOutputStream f_out = new FileOutputStream(filename);
             ObjectOutputStream obj_out = new ObjectOutputStream(f_out)
        ) {
            obj_out.writeObject(time);
            System.out.println("Time er gemt:" + time);
        } catch (IOException ex) {
            System.out.println("Error writing file");
            System.out.println(ex);
        }
    }

    public static MyTime getSavedTime (){
        String filename = "L15 - Arkitekture - Serializable/src/ex01/MyTimeFIL";
        try (FileInputStream f_in = new FileInputStream(filename);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            MyTime time = (MyTime) obj;
            System.out.println("Tiden er hentet: " + time);
            return time;
        } catch (ClassCastException ex) {
            System.out.println("Class of serialized object changed");
            System.out.println(ex);
            return null;
        } catch (IOException ex) {
            System.out.println("Error reading file");
            System.out.println(ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class of serialized object not found");
            System.out.println(ex);
            return null;
        }
    }
}
