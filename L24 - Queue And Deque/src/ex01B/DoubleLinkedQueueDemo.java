package ex01B;

import ex01A.QueueI;

public class DoubleLinkedQueueDemo {
    public static void main(String[] args) {
        QueueI<String> list = new DoubleLinkedQueue<>();

        list.add("Kurt");
        list.add("Lars");
        list.add("Kristoffer");

        System.out.println(list);



//        list.remove();
//
//        System.out.println(list);
//
//        System.out.println(list.size());
//
//        System.out.println(list.element());
//
//        list.clear();
//
//        System.out.println(list);
//
//        System.out.println(list.isEmpty());
//
//        list.add("jonas");
//
//        System.out.println(list.isEmpty());



    }
}
