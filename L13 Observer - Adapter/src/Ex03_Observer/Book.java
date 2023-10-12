package Ex03_Observer;

import java.util.ArrayList;

public class Book {
    private final String title;
    private int count;
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<BookObserver> bookObservers = new ArrayList<>();

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

    public void incCount(int amount) {
        count += amount;
    }

    public void decCount(int amount) {
        count -= amount;
        notifyObservers();
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        customer.books.add(this);
    }

    public void removeCustomer(Customer customer){
        customer.books.remove(this);
        customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public String toString() {
        return title + "(" + count + ")";
    }

    public void addObserver(BookObserver bo){
        bookObservers.add(bo);
    }

    public void removeObserver(BookObserver bo){
        bookObservers.remove(bo);
    }

    public void notifyObservers(){
        for (BookObserver e : bookObservers) {
            e.update(this);
        }
    }
}
