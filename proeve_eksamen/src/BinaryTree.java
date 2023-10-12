

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
        return root == null;
    }

    /**
     * Return the data at the root of this tree.
     * Pre: The tree is not empty.
     */
    public E rootData() {
        return root.data;
    }

    /**
     * Return a reference to the left subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public BinaryTree<E> left() {
        if(root.left == null){
            return null;
        }
        BinaryTree<E> leftTree = new BinaryTree<>();
        leftTree.root = root.left;
        return leftTree;
    }

    /**
     * Return a reference to the right subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public BinaryTree<E> right() {
        if(root.right == null){
            return null;
        }
        BinaryTree<E> rightTree = new BinaryTree<>();
        rightTree.root = root.right;
        return rightTree;
    }

    /**
     * counts the number of times the given element appears in the tree
     * @param element not null
     * Pre: root != null
     */
    public int countElement(E element){
        return countHelper(root, element);
    }

    private int countHelper(Node node, E target){
        if(node == null){
            return 0;
        } else if (node.data.equals(target)){
            return (1 + countHelper(node.left,target) + countHelper(node.right,target));
        } else {
            return (countHelper(node.left,target) + countHelper(node.right,target));
        }
    }

    //MAKE PRIVATE

    /**
     * calculates the values and operations below and including this node.
     * @throws RuntimeException if leaf is not a number or if an operation only got child.
     * Pre: n not null
     * @return calculation of nodes children, if the node is a leaf it returns an int.
     */
    private int value(Node n){
        if(n.left == null || n.right == null){
            try{
                return Integer.parseInt((String) n.data);
            }catch (NumberFormatException e){
                throw new RuntimeException("Malformed expression tree");
            }
        } else if (n.data.equals("*")) {
            return value(n.left) * value(n.right);
        } else{
            return value(n.left) + value(n.right);
        }
    }

    public int value(){
        return value(root);
    }

    /**
     *
     * Pre: tree not empty
     * @return
     */
    public String equationOfTree(){
        StringBuilder sb = new StringBuilder();
        equationHelper(root, sb);
        return sb.toString();
    }

    public void equationHelper(Node node, StringBuilder sb){
        if(node.left != null) {
            sb.append("(");
            equationHelper(node.left, sb);
            sb.append(" ");
        }
        sb.append(node.data);
        if(node.right != null){
            sb.append(" ");
            equationHelper(node.right, sb);
            sb.append(")");
        }

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
