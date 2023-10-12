package Ex03;

public class Main {
    public static void main(String[] args) {
        IntBinaryTree t25 = new IntBinaryTree(25);
        IntBinaryTree t30 = new IntBinaryTree(30, t25, null);

        IntBinaryTree t15 = new IntBinaryTree(15);
        IntBinaryTree t11 = new IntBinaryTree(11, null, t15);

        IntBinaryTree t22 = new IntBinaryTree(22,t11,t30);

        IntBinaryTree t88 = new IntBinaryTree(88);
        IntBinaryTree t90 = new IntBinaryTree(90, t88, null);

        IntBinaryTree t77 = new IntBinaryTree(77, null, t90);

        IntBinaryTree t45 = new IntBinaryTree(45,t22,t77);

        System.out.println(t45.getSum());

    }
}
