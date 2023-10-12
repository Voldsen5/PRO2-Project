package ex4student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class Ex4 {

    public static void main(String[] args) {
        List<Runner> runners = new ArrayList<>(List.of(
                new Runner("Ib", 30),
                new Runner("Per", 50),
                new Runner("Ole", 27),
                new Runner("Ulla", 40),
                new Runner("Jens", 35),
                new Runner("Hans", 28)
        ));
        System.out.println(runners);
        System.out.println();

        // Opgave 4 A:
        // OBS: Throws exception.
        for (Runner runner : runners) {
            if (runner.getLapTime() >=60) {
                runners.remove(runner);
            }
        }

        System.out.println(runners);
        System.out.println();

        // Opgave 4 B:

        ListIterator<Runner> runnerListIterator = runners.listIterator();

        while (runnerListIterator.hasNext()){
            if (runnerListIterator.next().getLapTime() >= 40) {
                runnerListIterator.remove();
            }
        }

        System.out.println(runners);
        System.out.println();


    }
    public static boolean removeIf(List<Runner> runners, Predicate<Runner> filter){
        Iterator<Runner> runnerIterator = runners.iterator();
        int size = runners.size();
        while (runnerIterator.hasNext()){
            Runner runner = runnerIterator.next();
            if (filter.test(runner)){
                runnerIterator.remove();
            }
        }
        return size != runners.size();
    };
}