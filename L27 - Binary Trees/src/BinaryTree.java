/**
 * BinaryTree models a binary tree.
 */
public class BinaryTree<E> {
    private Node root;

    /**
     * Create an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Create a binary tree with one node.
     */
    public BinaryTree(E rootData) {
        root = new Node(rootData);
    }

    /**
     * Create a BinaryTree with a root node, and
     * 'left' as left subtree and 'right' as right subtree.
     * Pre: 'left' != 'right'.
     * Note: 'left' and 'right' are nullable.
     */
    public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node(rootData);
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Return true if this tree is empty.
     */
    public boolean isEmpty() {
        // TODO
        return false;
    }

    /**
     * Return the data at the root of this tree.
     * Pre: The tree is not empty.
     */
    public E rootData() {
        // TODO
        return null;
    }

    /**
     * Return a reference to the left subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public BinaryTree<E> left() {
        // TODO
        return null;
    }

    /**
     * Return a reference to the right subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public BinaryTree<E> right() {
        // TODO
        return null;
    }

    public int countElement (E element) {
        Node node = root;
        int count = 0;
        boolean found = false;
        while (node != null) {
            if (element == node.data) {
                count++;
            }
            return count;
        }
        return count;
    }

    private String inOrder(E element){
        Node node = new Node((E) root);
        if (node == null){
            return "";
        }
        return inOrder((E) node.left) + node.data + " " + inOrder((E) node.right);
    }



    //-------------------------------------------------------------------------

    private class Node {
        private E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
