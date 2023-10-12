package ex01A;

import java.util.List;

public class SingleLinkedQueueDemo {
    public static void main(String[] args) {
        QueueI<String> list = new SingleLinkedQueue<>();

        list.add("Kristoffer");
        list.add("Lars");
        list.add("Kurt");
        list.add("Egon");

        System.out.println(list);

        list.remove();

        System.out.println(list);

        System.out.println(list.size());

        System.out.println(list.element());

        list.clear();

        System.out.println(list);

        System.out.println(list.isEmpty());

        list.add("jonas");

        System.out.println(list.isEmpty());



    }
}
