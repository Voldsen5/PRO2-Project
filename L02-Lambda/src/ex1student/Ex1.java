package ex1student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Filter;

public class Ex1 {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Bent", 25),
                new Person("Susan", 34),
                new Person("Mikael", 60),
                new Person("Klaus", 44),
                new Person("Birgitte", 17),
                new Person("Liselotte", 9)
        );
        System.out.println(persons);
        System.out.println();

        //Opgave 1.A
        Person p44 = findFirst(persons, p -> p.getAge() == 44);
        System.out.println("Første person der er præcis 44 år gammel:" + " " + p44.getName());

        //Opgave 1.b
        Person pS = findFirst(persons, p -> p.getName().startsWith("S"));
        System.out.println("Første person der starter med S:" + " " + pS.getName() );

        //Opgave 1c
        Person pII = findFirst(persons,p -> p.getName().indexOf("i") != p.getName().lastIndexOf("i"));
        System.out.println(pII);

        //Opgave 1d
        Person pSL = findFirst(persons,p -> p.getName().length() == p.getAge());
        System.out.println(pSL);

        //Opgave 1f
        List<Person> plI = findAll(persons,p -> p.getName().contains("i"));
        System.out.println(plI);

        //Opgave 1g
        List<Person> pSS = findAll(persons,p -> p.getName().startsWith("S"));
        System.out.println(pSS);

        //Opgave 1h
        List<Person> pL5 = findAll(persons,p -> p.getName().length() == 5);
        System.out.println(pL5);

        //Opgave 1i
        List<Person> p640 = findAll(persons,p -> p.getName().length() >= 6 && p.getAge() < 40);
        System.out.println(p640);


    }

    /**
     * Returns from the list the first person
     * that satisfies the predicate.
     * Returns null, if no person satisfies the predicate.
     */
    public static Person findFirst(List<Person> list, Predicate<Person> filter) {
        for (Person p : list) {
            if (filter.test(p))
                return p;
        }
        return null;
    }

    //Opgave 1e

    public static List<Person> findAll(List<Person> list, Predicate<Person> filter){
        List<Person> personList = new ArrayList<>();
        for (Person p : list){
            if (filter.test(p))
                personList.add(p);
        }
        return personList;
    }
}
