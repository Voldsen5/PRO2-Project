package observer_ex3student;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList<Book> books = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<Book>(books);
    }

    public void addBooks(Book book){
        books.add(book);
        book.customers.add(this);
    }

    public void removeBook(Book book){
        books.remove(book);
        book.customers.remove(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
