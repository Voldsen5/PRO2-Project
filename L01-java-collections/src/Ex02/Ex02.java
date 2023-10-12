package Ex02;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {

        ArrayList<Integer> as1 = new ArrayList<>();
        ArrayList<Integer> as2 = new ArrayList<>();
        ArrayList<Integer> as3 = new ArrayList<>();
        ArrayList<Integer> as4 = new ArrayList<>();
        ArrayList<Integer> as5 = new ArrayList<>();

        as1.add(4);
        as1.add(7);
        as1.add(10);

        as2.add(12);
        as2.add(10);
        as2.add(10);

        as3.add(4);
        as3.add(7);
        as3.add(2);

        as4.add(2);
        as4.add(2);
        as4.add(2);

        as5.add(12);
        as5.add(12);
        as5.add(12);

        Student s1 = new Student(1,"Kristoffer",as1);
        Student s2 = new Student(2,"Andreas",as2);
        Student s3 = new Student(3,"Rasmus",as3);
        Student s4 = new Student(4,"Oliver",as4);
        Student s5 = new Student(5,"Mathias",as5);
        Student s6 = new Student(6,"Leon",as4);

        College c1 = new College("Soendervangskolen");

        c1.addStudents(s1);
        c1.addStudents(s2);
        c1.addStudents(s3);
        c1.addStudents(s4);
        c1.addStudents(s5);
        c1.addStudents(s6);

        System.out.println(c1.calcAverage());
        System.out.println(c1.findStudent(1).toString());
    }
}
