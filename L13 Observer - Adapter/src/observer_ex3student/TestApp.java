package observer_ex3student;

public class TestApp {

    public static void main(String[] args) {
        //TODO: create a salesman and a purchaser
        Salesman salesman1 = new Salesman("Lars");
        Purchaser purchaser1 = new Purchaser("Kurt");

        Book b1 = new Book("Donald Duck");
        //TODO: add observers


        //TODO: make purchaser buy 6 copies of b1

        Book b2 = new Book("Java");
        //TODO: add observers

        //TODO: make purchaser buy 8 copies of b2
        System.out.println();

        Book b3 = new Book("Design Patterns");
        //TODO: add observers

        //TODO: make purchaser buy 10 copies of b3
        System.out.println();

        Customer c1 = new Customer("Bob");
        Customer c2 = new Customer("Alice");
        Customer c3 = new Customer("Harry");

        //---------------------------------------------------------------------

        TestApp.makeSale(b1, c1);
        System.out.println();
        TestApp.makeSale(b1, c2);
        System.out.println();
        TestApp.makeSale(b1, c3);
        System.out.println();

        TestApp.makeSale(b2, c1);
        System.out.println();
        TestApp.makeSale(b2, c2);
        System.out.println();
        TestApp.makeSale(b2, c3);
        System.out.println();

        TestApp.makeSale(b3, c1);
        System.out.println();

        //TODO: print each customer and his/her books
    }

    public static void makeSale(Book b, Customer c) {
        System.out.println("Sale: " + b + " sold to " + c.getName());
        //TODO: link customer and book
        b.decCount(1);
    }
}
