package observer_ex3student;

import java.util.HashSet;
import java.util.Set;

public class Salesman implements  BookObserver {
    private final String name;

    public Salesman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Book book) {
        Set<Book> books = new HashSet<>();
        for (int i = 0; i < book.customers.size(); i++) {

        }
        books.remove(book);
        System.out.println(books);


    }
}
