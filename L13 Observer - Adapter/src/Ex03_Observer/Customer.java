package Ex03_Observer;

import java.util.ArrayList;

public class Customer {
    private final String name;
    final ArrayList<Book> books = new ArrayList<>(); //package visible

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public String toString() {
        return name;
    }
}
