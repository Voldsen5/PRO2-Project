package Ex03_Observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Salesman implements BookObserver{
    private final String name;

    public Salesman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Book book) {
        Set<Book> recommendedBooks = new HashSet<>();
        for(Customer e : book.getCustomers()){
            recommendedBooks.addAll(e.getBooks());
        }
        recommendedBooks.remove(book);
        for(Book e : recommendedBooks){
            System.out.println("Others have purchased: " + e);
        }
    }
}
