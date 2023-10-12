package Ex02_Observer;

public class App {
    public static void main(String[] args) {
        Observer obs1 = new BagObserver();
        Observer obs2 = new BagObserver();
        Observer obs3 = new BagObserver();

        ObservableBag obsBag = new ObservableBag();
        obsBag.addObserver(obs1);
        obsBag.addObserver(obs2);
        obsBag.addObserver(obs3);

        obsBag.add("Marabou");
        obsBag.add("Tempranillo");
        obsBag.add("Lagret Ost");
        obsBag.add("Marabou");
        obsBag.remove("Lagret Ost");

    }
}
