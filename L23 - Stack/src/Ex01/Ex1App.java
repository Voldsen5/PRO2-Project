package Ex01;

public class Ex1App {

    public static void main(String[] args) {
        StackI<String> s = new DequeStack<>();
        //StackI<String> s = new LinkedStack<>();
        //StackI<String> s = new ArrayStack<>();
        s.push("Tom");
        s.push("Diana");
        s.push("Harry");
        s.push("Thomas");
        s.push("Bob");
        s.push("Brian");
        System.out.println(s.peek());
        System.out.println(s.isEmpty() + " " + s.size());
        System.out.println();

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println();

        System.out.println(s.isEmpty() + " " + s.size());
        System.out.println();

        // -------- test of reverse --------

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static <E> void reverse(E[] table) {
        //StackI<E> stack = new ArrayStack<E>(table.length);
        //StackI<E> stack = new LinkedStack<E>();
        StackI<E> stack = new DequeStack<>();
        for (E e : table) {
            stack.push(e);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            table[i] = stack.pop();
            i++;
        }
    }

}
