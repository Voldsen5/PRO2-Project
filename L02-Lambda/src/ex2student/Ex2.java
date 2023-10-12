package ex2student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Filter;

public class Ex2 {

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


        //Opg 2 A:
        System.out.println();

        runners.forEach(System.out::println);

        //Opg 2 B:
        System.out.println();

        runners.forEach(runner -> {
            if (runner.getLapTime() < 30)
                System.out.println("Runner[" + runner.getName() + ", " + runner.getLapTime() + "]");
        });

        //Opg 2 C:
        System.out.println();

        Comparator<Runner> runnerComparator = Comparator.comparingInt(Runner::getLapTime);
        runners.sort(runnerComparator);
        runners.forEach(System.out::println);
    }
}