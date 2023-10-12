package Ex03;

/**
 * BinaryTree models a binary tree.
 */
public class IntBinaryTree {
    private Node root;

    /**
     * Create an empty binary tree.
     */
    public IntBinaryTree() {
        root = null;
    }

    /**
     * Create a binary tree with one node.
     */
    public IntBinaryTree(int rootData) {
        root = new Node(rootData);
    }

    /**
     * Create a BinaryTree with a root node, and
     * 'left' as left subtree and 'right' as right subtree.
     * Pre: 'left' != 'right'.
     * Note: 'left' and 'right' are nullable.
     */
    public IntBinaryTree(int rootData, IntBinaryTree left, IntBinaryTree right) {
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
     * Pre: The tree is not empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Return the data at the root of this tree.
     */
    public int rootData() {
        return root.data;
    }

    /**
     * Return a reference to the left subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public IntBinaryTree left() {
        IntBinaryTree leftSubtree = new IntBinaryTree();
        leftSubtree.root = root.left;
        return leftSubtree;
    }

    /**
     * Return a reference to the right subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public IntBinaryTree right() {
        IntBinaryTree rightSubTree = new IntBinaryTree();
        rightSubTree.root = root.right;
        return rightSubTree;
    }

    public int getSum(){
        return getSumHelper(root);
    }

    private int getSumHelper(Node root){
        return root == null ? 0 : (root.data + getSumHelper(root.left) + getSumHelper(root.right));
    }

    //-------------------------------------------------------------------------

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
