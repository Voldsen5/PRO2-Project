package Ex02;


public class main {
    public static void main(String[] args) {
        QueueI<String> q = new CircularArrayQueue<>();
        q.add("Tom");;
        q.add("Diana");
        q.add("Harry");
        q.add("Thomas");
        q.add("Bob");
        q.add("Brian");
        System.out.println(q);
        q.add("Henry");
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add("Eric");
        q.add("Bastian");
        q.add("Chester");
        q.add("Jay");
        q.add("John");
        q.add("Bianca");
        System.out.println(q);
    }
}
