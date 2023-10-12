package ex01C;



public class main {
    public static void main(String[] args) {
        QueueI<String> q = new ArrayQueue<>();
        q.add("Tom");;
        q.add("Diana");
        q.add("Harry");
        q.add("Thomas");
        q.add("Bob");
        q.add("Brian");
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println();
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println();
        System.out.println(q);
    }
}
