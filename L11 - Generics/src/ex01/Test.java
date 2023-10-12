package ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List personListe = new ArrayList<Person<FullName>>();



        FullName fn= new FullName("Kurt","Kurtsen");

        Person person = new Person<String>("Lars",3);
        Person person1 = new Person<FullName>(fn,3);

        Person p1 = new Person<String>("Lars", 2);
        Person p2 = new Person<String>("Yvette", 3);
        Person p3 = new Person<String>("Jens",4);
        Person p4 = new Person<String>("Karl",6);

        personListe.add(p1);
        personListe.add(p2);
        personListe.add(p3);
        personListe.add(p4);

        System.out.println(personListe);
        Collections.sort(personListe);
        System.out.println(personListe);

    }
}
