package Ex02;


import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        MyTime mytime = new MyTime();
//        mytime.increase();
//        mytime.increase();
//        mytime.increase();
        MyTime mytime = null;

        String fileName = "L15-Architecture_Serializable/src/Ex02/MyTime.ser";
        try (FileInputStream f_in = new FileInputStream(fileName);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            mytime = (MyTime) obj;
            System.out.println("Time loaded is: " + mytime.getTime());
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

        mytime.increase();
        mytime.increase();

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)
        ){
            objOut.writeObject(mytime);
            System.out.println("Time saved is: " + mytime.getTime());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
