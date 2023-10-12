package Ex02;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackI<E> {
    // top of stack is at head of list (i.e.at first)
    private Node first;
    // the number of element in the stack
    int size;

    public LinkedStack() {
        first = null;
        size = 0;
    }

    /**
     * Adds a new entry to the top of this stack.
     */
    @Override
    public void push(E entry) {
        Node newNode = new Node(entry);
        if(first != null){
            newNode.next = first;
        }
        first = newNode;
        size++;
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
