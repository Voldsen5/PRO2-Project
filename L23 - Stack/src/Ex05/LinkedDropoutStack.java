package Ex05;

import java.util.NoSuchElementException;

public class LinkedDropoutStack<E> implements StackI<E> {
    // top of stack is at head of list (i.e.at first)
    private Node first;
    // the number of element in the stack
    int size;
    // dropout capacity
    int capacity;

    public LinkedDropoutStack(int capacity) {
        first = null;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Adds a new entry to the top of this stack.
     */
    @Override
    public void push(E entry) {
        if(size == capacity){
            dropout();
        }
        Node newNode = new Node(entry);
        if(first != null){
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    public void dropout(){
        Node node = first;
        while(node.next.next != null){
            node = node.next;
        }
        node.next = null;
    }

    /**
     * Removes and returns this stack's top entry.
     * Throws NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {
        if (first == null){
            throw new NoSuchElementException();
        }
        E popped = first.entry;
        first = first.next;
        size--;
        return popped;
    }

    /**
     * Returns the stack's top entry.
     * Throws NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {
        if (first == null){
            throw new NoSuchElementException();
        }
        return first.entry;
    }

    /**
     * Returns true if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Removes all entries from the stack.
     */
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the stack.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void print(){
        Node node = first;
        while(node.next != null){
            System.out.println(node.entry);
            node = node.next;
        }
    }

    //-------------------------------------------------------------------------

    private class Node {
        private final E entry;
        private Node next;

        public Node(E entry) {
            this.entry = entry;
            this.next = null;
        }
    }

}
