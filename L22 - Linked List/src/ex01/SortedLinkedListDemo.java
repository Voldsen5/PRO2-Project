package ex01;

public class SortedLinkedListDemo {
    public static void main(String[] args) {
        String person1 = new String("A");
        String person2 = new String("B");
        String person3 = new String("C");
        String person4 = new String("E");
        String person5 = new String("D");
        
        SortedLinkedList list = new SortedLinkedList();

        list.add(person2);


        list.add(person1);


        list.add(person3);


        list.add(person4);


        list.add(person5);
        list.printElements();
        System.out.println(list.removeLast());
        list.printElements();

        list.remove(person1);

        list.printElements();

        
    }
}
