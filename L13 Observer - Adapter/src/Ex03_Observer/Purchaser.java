package Ex03_Observer;

public class Purchaser implements BookObserver{
    private final String name;

    public Purchaser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void purchaseBook(Book b, int amount) {
        System.out.println("Purchase: " + b + ", " + amount + " copies");
        b.incCount(amount);
    }

    @Override
    public void update(Book book) {
        if(book.getCount() < 6){
            purchaseBook(book, 10);
        }
    }
}
