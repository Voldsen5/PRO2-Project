package Ex05;

public class main {
    public static void main(String[] args) {
        //StackI<String> s = new ArrayDropoutStack<>(10);
        StackI<String> s = new LinkedDropoutStack<>(10);
        s.push("Tom");
        s.push("Diana");
        s.push("Harry");
        s.push("Thomas");
        s.push("Bob");
        s.push("Brian");
        s.print();
        System.out.println();
        s.push("Jim");
        s.push("Darwin");
        s.push("Jett");
        s.push("Zack");
        s.push("Henry");
        s.push("Martin");
        System.out.println();
        s.print();
    }

}
