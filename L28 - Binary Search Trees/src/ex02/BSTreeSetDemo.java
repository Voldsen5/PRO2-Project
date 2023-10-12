package ex02;

public class BSTreeSetDemo {
    public static void main(String[] args) {
        BSTreeSet<Integer> treeSet = new BSTreeSet<>();

        treeSet.add(45);
        treeSet.add(22);
        treeSet.add(77);
        treeSet.add(90);
        treeSet.add(30);
        treeSet.add(25);
        treeSet.add(11);
        treeSet.add(55);
        treeSet.add(54);



        System.out.println("Tree Set: " + treeSet);
        System.out.println();

        System.out.println("Max: " + treeSet.max());
        System.out.println();

        System.out.println("Tree Set indholder 90: " + treeSet.contains(90));
        System.out.println();

        System.out.println("Tree Set indholder 100: " + treeSet.contains(100));
        System.out.println();

        System.out.println("Tree Set element Slettet: " + treeSet.remove(90));
        System.out.println();

        System.out.println("Tree Set: " + treeSet);
        System.out.println();

        System.out.println("Max: " + treeSet.max());
        System.out.println();

        System.out.println("Min Remove: " + treeSet.removeMin());
        System.out.println();

        System.out.println("Tree Set: " + treeSet);
        System.out.println();
    }
}
