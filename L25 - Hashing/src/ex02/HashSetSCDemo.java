package ex02;

public class HashSetSCDemo {
    public static void main(String[] args) {
        HashSetSC<Object> hist = new HashSetSC<>(10);

        String s1 = "Kristoffer";
        String s2 = "Carsten";
        String s3 = "Lars";

        hist.add(s1);
        hist.add(s2);
        hist.add(s3);

        System.out.println(hist.toString());

    }
}
