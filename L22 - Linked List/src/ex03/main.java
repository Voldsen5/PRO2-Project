package ex03;


public class main {
    public static void main(String[] args) {
        SortedLinkedList list1 = new SortedLinkedList();
        list1.add("Benny");
        list1.add("Lars");
        list1.add("Allan");
        list1.add("Jan");
        list1.printElements();

        System.out.println();

        SortedLinkedList list2 = new SortedLinkedList();
        list2.add("Charlie");
        list2.add("Karsten");
        list2.add("Benny");
        list2.add("Henrik");
        list2.add("Suen");
        list2.printElements();

        System.out.println();

        list1.addAll(list2);
        list1.printElements();
    }
}
