package ureksempel;

import java.util.ArrayList;
import java.util.List;

// Subject
public class UrEngine {
    private int tid = 0;

    public int getTid() {
        return tid;
    }

    public void tiktak() {
        tid++;
        notifyObservers();
    }

    //-----------------------------------------------------

    private final List<UrEngineObserver> observers = new ArrayList<>();

    public void addUrObserver(UrEngineObserver observer) {
        observers.add(observer);
    }

    public void removeUrObserver(UrEngineObserver observer) {
        observers.remove(observer);
    }

//    private void notifyObservers() { // pull
//        for (Observer urObserver : observers) {
//            observer.update(this);
//        }
//    }

    private void notifyObservers() { // push
        for (UrEngineObserver observer : observers) {
            observer.update(tid);
        }
    }
}
