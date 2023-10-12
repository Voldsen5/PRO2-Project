package observer_ex3student;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String title;
    private int count;
    final ArrayList<Customer> customers = new ArrayList<>();
    private final List<BookObserver> observers = new ArrayList<>();

    public Book(String title) {
        this.title = title;
        this.count = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(customers);
    }

    public void incCount(int amount) {
        count += amount;
    }

    public void decCount(int amount) {
        count -= amount;
        notifyObservers();
    }

    @Override
    public String toString() {
        return title + "(" + count + ")";
    }

    public void addBookObserver(BookObserver observer){
        observers.add(observer);
    }

    public void removeBookObserver(BookObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(){
        for (BookObserver observer : observers){
            observer.update(this);
        }
    }
}
