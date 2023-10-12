package ex3student;

import java.awt.print.Printable;
import java.util.*;

public class Ex3 {
    public static void main(String[] args) {

        //Opgave 3 A

        LinkedList<Integer> tals = new LinkedList<>();

        tals.add(1);
        tals.add(2);
        tals.add(3);
        tals.add(4);
        tals.add(5);
        tals.add(6);
        tals.add(7);
        tals.add(8);

        ListIterator<Integer> iterator = tals.listIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Opgave 3 B

        Map<Integer,Integer> integerMap = new HashMap<>();
        integerMap.put(2,4);
        integerMap.put(3,9);
        integerMap.put(4,16);
        integerMap.put(5,25);
        integerMap.put(6,36);

        Set<Integer> keySet = integerMap.keySet();
        for (Integer key : keySet){
            Integer val = integerMap.get(key);
            System.out.println(key + " " + val);

        }

    }
}
