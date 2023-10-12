package Ex02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyTime implements Serializable {
    private List<String> times = new ArrayList<>();
    private int time = 0;

    public MyTime() {

    }

    public int getTime() {
        return time;
    }

    public void increase(){
        time++;
    }

    public void reset(){
        time = 0;
    }

    public void saveTime(){
        times.add(String.valueOf(time));
    }
}
