package Ex02_Observer;

public class BagObserver implements Observer{

    public BagObserver() {
    }

    @Override
    public void update(String obj, int antal) {
        System.out.printf("%s has been updated, values is now at %d\n", obj, antal);
    }
}
