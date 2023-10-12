public class Main {
    public static void main(String[] args) {
        BinaryTree<String> t2 = new BinaryTree<>("2");
        BinaryTree<String> t4 = new BinaryTree<>("4");
        BinaryTree<String> tPlus = new BinaryTree<>("+",t2,t4);

        BinaryTree<String> t7 = new BinaryTree<>("7");
        BinaryTree<String> tTimes = new BinaryTree<>("*",tPlus,t7);

        BinaryTree<String> t3 = new BinaryTree<>("3");
        BinaryTree<String> t8 = new BinaryTree<>("8");
        BinaryTree<String> tPlus1 = new BinaryTree<>("+", t3, t8);

        BinaryTree<String> rPlus = new BinaryTree<>("+", tTimes, tPlus1);

        System.out.println(rPlus.countElement("9"));

        System.out.println(rPlus.equationOfTree() + " = " + rPlus.value());

    }
}
