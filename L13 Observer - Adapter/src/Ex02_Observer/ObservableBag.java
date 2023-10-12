package Ex02_Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class ObservableBag implements Bag{
    public ObservableBag() {
    }
    private final HashMap<String, Integer> bag = new HashMap<>();

    @Override
    public void add(String s) {
        if(bag.containsKey(s)){
            bag.put(s, bag.get(s) + 1);
        }else{
            bag.put(s,1);
        }
        notifyOberservers(s);
    }

    @Override
    public void remove(String s) {
        if(bag.containsKey(s)){
            if(bag.get(s) - 1 > 0){
                bag.put(s, bag.get(s) - 1);
            } else{
                bag.remove(s);
            }
        }
        notifyOberservers(s);
    }

    @Override
    public int getCount(String s) {
        return bag.get(s);
    }

    //-------------------------------------------------------------------------------//
    private final ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    private void notifyOberservers(String obj){
        for (Observer e : observers) {
            e.update(obj, bag.getOrDefault(obj, 0));
        }
    }
}
