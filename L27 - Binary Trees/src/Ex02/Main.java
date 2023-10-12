package Ex02;


public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> t25 = new BinaryTree<>(25);
        BinaryTree<Integer> t30 = new BinaryTree<>(30, t25, null);

        BinaryTree<Integer> t15 = new BinaryTree<>(15);
        BinaryTree<Integer> t11 = new BinaryTree<>(11, null, t15);

        BinaryTree<Integer> t22 = new BinaryTree<>(22,t11,t30);

        BinaryTree<Integer> t88 = new BinaryTree<>(88);
        BinaryTree<Integer> t90 = new BinaryTree<>(90, t88, null);

        BinaryTree<Integer> t77 = new BinaryTree<>(77, null, t90);

        BinaryTree<Integer> t45 = new BinaryTree<>(45,t22,t77);

        System.out.println(t45.getHeight());

        System.out.println(t45.getSize());

        System.out.println(t45.getLeafCount());

        t45.printPreorder();
        System.out.println();
        t45.printInorder();
        System.out.println();
        t45.printPostorder();
        System.out.println();
        t45.printLevelOrder();
        System.out.println();
        System.out.println(t45.listInorder());
    }
}
