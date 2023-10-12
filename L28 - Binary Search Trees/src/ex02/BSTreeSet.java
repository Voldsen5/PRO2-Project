package ex02;

/**
 * BSTreeSet implements a sorted set, sorted according to the elements' natural ordering.
 * Elements in the set of type E must implement the Comparable<E> interface.
 * Note: Equal elements are not allowed in the set. Equality of two elements is
 * decided by the elements' compareTo() method.
 * Note: Elements must have a compareTo() method that is consistent with equals(),
 * that is, e1.compareTo(e2) == 0 <=> e1.equals(e2) == true.
 */
public class BSTreeSet<E extends Comparable<E>> {
    // BSTreeSet is implemented as a binary search tree.

    private Node root;

    private int size;

    /**
     * Create an empty BSTreeSet.
     */
    public BSTreeSet() {
        root = null;
    }

    //-------------------------------------------------------------------------

    // Return a NodePair consisting of the node
    // containing 'element' and the node's parent.
    // If root contains 'element', node is root, and parent is null.
    // If no node contains 'element', node is null,
    // and parent is the node where 'element' would be added.
    // Pre: The tree is not empty.
    private NodePair findNodeAndParent(E element) {
        Node parent = null;
        Node node = root;
        boolean found = false;
        while (!found && node != null) {
            int d = element.compareTo(node.data);
            if (d == 0) {
                found = true;
            } else {
                parent = node;
                if (d < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return new NodePair(node, parent);
    }

    private class NodePair {
        private final Node node;
        private final Node parent;

        public NodePair(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Add 'element' to the set, if 'element' is not already present.
     * Return true, if 'element' is added.
     */

    public boolean add(E element) {

        Node newNode = new Node(element);
        NodePair placement = findNodeAndParent(element);

        if (root == null){
            root = newNode;
            size = 1;
            return true;
        }


        if (placement.node != null){
            return false;
        }

        if (placement.parent.data.compareTo(element) > 0){
            placement.parent.left = newNode;
        } else {
            placement.parent.right = newNode;
        }
        size++;
        return true;
   }

    /**
     * Return true, if the set contains 'element'.
     */
    public boolean contains(E element) {

        if (root.data == null){
            return false;
        }
        NodePair placement = findNodeAndParent(element);

        return placement.node != null;
    }

    /**
     * Remove 'element' from the set, if it is present.
     * Return true, if 'element' is removed.
     */
    public boolean remove(E element) {
        // guard: tree is empty
        if (root == null)
            return false;

        // look for node containing element
        NodePair pair = this.findNodeAndParent(element);
        Node toBeRemoved = pair.node;
        Node parent = pair.parent;

        // guard: element is not in the tree
        if (toBeRemoved == null)
            return false;

        if (toBeRemoved.left == null || toBeRemoved.right == null) {
            // one child is null (or both)

            // child is the not-null child of toBeRemoved (or null if both children are  null)
            Node child = (toBeRemoved.left != null) ? toBeRemoved.left : toBeRemoved.right;

            if (parent == null) {
                // toBeRemoved is the root
                root = child;
            } else if (parent.left == toBeRemoved) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            // both children of toBeRemoved are not null

            // find the smallest element of the right subtree
            Node parentOfSmallest = toBeRemoved;
            Node smallest = toBeRemoved.right;
            while (smallest.left != null) {
                parentOfSmallest = smallest;
                smallest = smallest.left;
            }
            // smallest now contains the smallest child in right subtree (and its left child is null)

            // move content of smallest to toBeRemoved, remove smallest
            toBeRemoved.data = smallest.data;
            if (parentOfSmallest == toBeRemoved) {
                parentOfSmallest.right = smallest.right;
            } else {
                parentOfSmallest.left = smallest.right;
            }
        }
        size++;
        return true;
    }


    /**
     * Return a string containing all elements in sorted order.
     */
    private String inOrder(Node node){
        if (node == null){
            return "";
        }
        return inOrder(node.left) + node.data + " " + inOrder(node.right);
    }

    /**
     * Return a string containing all elements in sorted order.
     */
    @Override
    public String toString() {
        return inOrder(root);
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns the largest entry in the binary search tree.
     * If the tree is empty, null is returned.
     **/
    public E max(){
        Node node = root;

        if (root == null){
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    /**
     * Removes and returns the smallest entry in the binary search tree.
     * If the tree is empty, null is returned.
     **/
    public E removeMin(){
        Node node = root;

        if (root == null){
            return null;
        }

        while (node.left != null){
            node = node.left;
        }
        this.remove(node.data);
        return node.data;
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
