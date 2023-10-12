package Ex03;



import java.util.NoSuchElementException;

public class DoubleLinkedDeque<E> implements DequeI<E> {
    private Node header;
    private Node trailer;
    private int size;

    public DoubleLinkedDeque() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    @Override
    public void addFirst(E entry) {
        Node newNode = new Node(entry);
        newNode.next = header.next;
        newNode.prev = header;
        header.next.prev = newNode;
        header.next = newNode;
        size++;
    }

    @Override
    public void addLast(E entry) {
        Node newNode = new Node(entry);
        newNode.next = trailer;
        newNode.prev = trailer.prev;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if(header.next == trailer){
            throw new NoSuchElementException();
        }
        E popped = header.next.entry;
        header.next = header.next.next;
        header.next.prev = header;
        size--;
        return popped;
    }

    @Override
    public E removeLast() {
        if(header.next == trailer){
            throw new NoSuchElementException();
        }
        E popped = trailer.prev.entry;
        trailer.prev = trailer.prev.prev;
        trailer.prev.next = trailer;
        size--;
        return popped;
    }

    @Override
    public E getFirst() {
        if(header.next == trailer){
            throw new NoSuchElementException();
        }
        return header.next.entry;
    }

    @Override
    public E getLast() {
        if(header.next == trailer){
            throw new NoSuchElementException();
        }
        return trailer.prev.entry;
    }

    @Override
    public boolean isEmpty() {
        return header.next == trailer;
    }

    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(header.next == trailer){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node node = header.next;
        while(node != trailer){
            sb.append(node.entry).append("\n");
            node = node.next;
        }
        if(sb.toString().equals("")){
            sb.append("Empty");
        }
        return sb.toString();
    }

    //--------------------------------------------------

    private class Node {
        private E entry;
        private Node prev;
        private Node next;

        public Node(E entry) {
            this.entry = entry;
            this.prev = null;
            this.next = null;
        }
    }
}
