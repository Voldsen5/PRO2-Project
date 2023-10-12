package ex02;


public class SortedDoubleLinkedList {
    private Node header;
    private Node trailer;

    public SortedDoubleLinkedList() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
    }

    /**
     * Add the element to the list.
     * The list is still sorted after the element is added.
     */
    public void add(String element) {
        if(header.next == trailer || header.next.data.compareTo(element) > 0){ // guard
            Node newNode = new Node(element);
            newNode.next = header.next;
            newNode.prev = header;
            header.next = newNode;
            return;
        }

        boolean placed = false;
        Node node = header.next;
        while(!placed && node.next != trailer){
            if(node.next.data.compareTo(element) >= 0){ // place in front of greater or strings equal to element
                Node newNode = new Node(element);
                newNode.next = node.next;
                newNode.prev = node;
                node.next.prev = newNode;
                node.next = newNode;
                placed = true;
            }
            node = node.next;
        }
        if(!placed){
            Node newNode = new Node(element);
            newNode.next = trailer;
            newNode.prev = node;
            node.next = newNode;
            trailer.prev = newNode;
        }
    }
    /**
     * Remove the last element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed, otherwise false.
     */

    public boolean removeLast(){
        if(trailer.prev != header){
            trailer.prev = trailer.prev.prev;
            trailer.prev.next = trailer;
            return true;
        }
        return false;
    }
    /**
     * Remove the first instance of the element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed, otherwise false.
     */
    public boolean remove(String element){
        if (header.next == trailer)
            return false;


        // update node to reference the node BEFORE the node
        // containing the city (if such a node exists)
        Node node = header;
        while (node.next != trailer && !node.next.data.equals(element)) {
            node = node.next;
        }
        if (node.next != trailer) {
            node.next.next.prev = node;
            node.next = node.next.next;

            return true;
        }
        return false;
    }

    /**
     * Print all elements in alphabetical order.
     */
    public void printElements() {
        if(header.next == trailer){
            System.out.println("Empty list");
            return;
        }
        Node node = header.next;
        while(node != trailer){
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * Return the count of elements in the list.
     */
    public int count() {
        int count = 0;
        if(header.next == trailer){
            return 0;
        }

        Node node = header.next;
        while(node != trailer){
            count++;
            node = node.next;
        }
        return count;
    }

    private class Node {
        private String data;
        private Node prev;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
