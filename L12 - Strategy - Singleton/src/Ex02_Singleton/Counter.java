package Ex02_Singleton;

public class Counter {
    private int value;
    private static Counter uniqueInstance;

    private Counter(){
        value = 0;
    }

    public static Counter getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Counter();
        }
        return uniqueInstance;
    }

    public void count(){
        value++;
    }

    public void times2(){
        value *= 2;
    }

    public void resetZero(){
        value = 0;
    }

    public int getValue() {
        return value;
    }
}
