package ex04;

public class Test {
    public static void main(String[] args) {
        ArrayedList<Integer> arrayedList = new ArrayedList<>();

        arrayedList.add(1);
        arrayedList.add(2);
        arrayedList.add(3);
        arrayedList.add(4);
        arrayedList.add(5);

        System.out.println(arrayedList);

        arrayedList.add(2,23);

        System.out.println(arrayedList);

        System.out.println(arrayedList.iterator().hasNext());
    }
}
