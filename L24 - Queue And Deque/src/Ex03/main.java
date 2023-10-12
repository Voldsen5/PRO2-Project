package Ex03;



public class main {
    public static void main(String[] args) {
        DequeI<String> q = new DoubleLinkedDeque<>();
        q.addFirst("Tom");;
        q.addFirst("Diana");
        q.addLast("Harry");
        q.addLast("Thomas");
        q.addFirst("Bob");
        q.addLast("Brian");
        System.out.println(q);
        System.out.println(q.removeFirst());
        System.out.println(q.removeFirst());
        System.out.println(q.removeLast());
        System.out.println();
        System.out.println(q);
        System.out.println(q.removeLast());
        System.out.println(q.removeFirst());
        System.out.println(q.removeLast());
        System.out.println();
        System.out.println(q);
    }
}
