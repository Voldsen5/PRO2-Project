package ureksempel;

public class TestObserverUr {

    public static void main(String[] args) {
        UrEngine ur = new UrEngine();
        UrEngineObserver analog = new AnalogtUrDisplay();
        UrEngineObserver digital = new DigitaltUrDisplay();
        ur.addUrObserver(analog);
        ur.addUrObserver(digital);

        for (int i = 0; i < 4; i++) {
            ur.tiktak();
            System.out.println();
        }
    }
}
