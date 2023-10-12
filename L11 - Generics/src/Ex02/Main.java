package Ex02;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("A)\n");
        HashSet<Integer> set1 = new HashSet<>(List.of(1,5,8,6,2));
        HashSet<Integer> set2 = new HashSet<>(List.of(3,4,7,8,9));
        System.out.println(union(set1,set2));

        System.out.printf("\nB)\n");
        HashSet<Integer> set3 = new HashSet<>(List.of(2,3,8,6,7));
        HashSet<Integer> set4 = new HashSet<>(List.of(3,4,7,8,9));
        System.out.println(intersect(set3,set4));

        HashSet<String> set5 = new HashSet<>(List.of("hi", "im", "depressed", "and", "thats", "nice"));
        HashSet<String> set6 = new HashSet<>(List.of("hi", "depressed", "im", "dad"));
        System.out.println(intersect(set5,set6));

        System.out.printf("\nC)\n");
        System.out.println(difference(set3,set4));
        System.out.println(difference(set5,set6));

        System.out.printf("\nD)\n");
        HashSet<String> set7 = new HashSet<>(List.of("oh", "well", "that","happens"));
        System.out.println(difference(set1, set2, set3));
        System.out.println(difference(set5, set6, set7));
    }

    public static <E> HashSet<E> union(HashSet<E> set1, HashSet<E> set2){
        HashSet<E> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }

    public static <E> HashSet<E> intersect(HashSet<E> set1, HashSet<E> set2){
        HashSet<E> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    public static <E> HashSet<E> difference(HashSet<E> set1, HashSet<E> set2){
        HashSet<E> difference = new HashSet<>();
        for (E e : set1) {
            if(!set2.contains(e)){
                difference.add(e);
            }
        }

        return difference;
    }

    public static <E> HashSet<E> difference(HashSet<E> set1, HashSet<E> set2, HashSet<E> set3){
        set3.addAll(set1);
        set3.addAll(set2);
        return set3;
    }
}
