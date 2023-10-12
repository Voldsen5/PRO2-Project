package Ex01;

import java.util.HashSet;
import java.util.Set;

public class UseMethodsWithHashSet {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(34);
        numbers.add(12);
        numbers.add(23);
        numbers.add(45);
        numbers.add(67);
        numbers.add(34);
        numbers.add(98);

        System.out.println(numbers);

        numbers.add(23);

        System.out.println(numbers);

        numbers.remove(67);

        System.out.println(numbers);

        System.out.println(numbers.contains(23));

        System.out.println(numbers.size());
    }
}
