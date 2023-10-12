package Ex03;


public class Main {
    public static void main(String[] args) {
        HashSetLP<String> hs = new HashSetLP<>(10);

        hs.add("Allan");
        hs.add("Henrik");
        hs.add("Lars");
        hs.add("Karsten");
        hs.add("Charlie");
        hs.add("James");

        System.out.println(hs.contains("Lars"));

        System.out.println(hs);

        System.out.println(hs.remove("Lars"));

        System.out.println(hs);
    }
}
