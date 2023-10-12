package ex03;


public class SortedLinkedList {
    private Node first;

    public SortedLinkedList() {
        first = null;
    }

    /**
     * Add the element to the list.
     * The list is still sorted after the element is added.
     */
    public void add(String element) {
        if(first == null || first.data.compareTo(element) > 0){ // guard
            Node newNode = new Node(element);
            newNode.next = first;
            first = newNode;
            return;
        }

        boolean placed = false;
        Node node = first;
        while(!placed && node.next != null){
            if(node.next.data.compareTo(element) >= 0){ // place in front of greater or strings equal to element
                Node newnode = new Node(element);
                newnode.next = node.next;
                node.next = newnode;
                placed = true;
            }
            node = node.next;
        }
        if(!placed){
            node.next = new Node(element);
        }
    }

    /**
     * Add all the element to the list.
     * The list is still sorted after the element is added.
     */
    public void addAll(SortedLinkedList list){
        SortedLinkedList mergedList = new SortedLinkedList();

        Node l1Node = list.first;
        Node l2Node = this.first;
        mergedList.add("");
        Node merged = mergedList.first;
        while(l1Node != null && l2Node != null){
            if(l1Node.data.compareTo(l2Node.data) <= 0){
                merged.next = l1Node;
                l1Node = l1Node.next;
            }else{
                merged.next = l2Node;
                l2Node = l2Node.next;
            }

            merged = merged.next;
        }

        while(l1Node != null){
            merged.next = l1Node;
            l1Node = l1Node.next;
            merged = merged.next;
        }

        while(l2Node != null){
            merged.next = l2Node;
            l2Node = l2Node.next;
            merged = merged.next;
        }

        first = mergedList.first.next;
    }

    /**
     * Remove the last element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed, otherwise false.
     */

    public boolean removeLast(){
        if(first == null){ // guard
            return false;
        }

        if(first.next == null){ // guard
            first = null;
            return true;
        }

        Node node = first;
        while(node.next != null){
            if(node.next.next == null){
                node.next = null;
                return true;
            }
            node = node.next;
        }
        return false;
    }
    /**
     * Remove the first instance of the element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed, otherwise false.
     */
    public boolean remove(String element){
        if (first == null)
            return false;

        if (first.data.equals(element)) {
            first = first.next;
            return true;
        }

        // update node to reference the node BEFORE the node
        // containing the city (if such a node exists)
        Node node = first;
        while (node.next != null && !node.next.data.equals(element)) {
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
            return true;
        }
        return false;
    }

    /**
     * Print all elements in alphabetical order.
     */
    public void printElements() {
        if(first == null){
            System.out.println("Empty list");
            return;
        }
        Node node = first;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * Return the count of elements in the list.
     */
    public int count() {
        int count = 0;
        if(first == null){
            return 0;
        }

        Node node = first;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    private class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
}
