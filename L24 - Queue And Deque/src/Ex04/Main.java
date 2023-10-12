package Ex04;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Henry");
        Person p2 = new Person("Eric");
        Person p3 = new Person("Sebastian");
        Person p4 = new Person("Clark");
        Person p5 = new Person("Hammond");

        Circle c = new Circle();
        c.addPerson(p1);
        c.addPerson(p2);
        c.addPerson(p3);
        c.addPerson(p4);
        c.addPerson(p5);
        c.printPersons();
        System.out.println();

        System.out.println(c.removeFirst());
        System.out.println(c.getSize());
        for (int i = 0; i < c.getSize()+3; i++) {
            System.out.println(c.removeNext(3));
        }
        c.printPersons();
    }
}
