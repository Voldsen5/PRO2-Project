package Ex02;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackI<E> {
    // the index of the top entry in the stack,
    // top is -1 if the stack is empty
    private int top;
    // contains the entries in the stack
    private E[] entries;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        entries = temp;
        top = -1;
    }

    /**
     * Adds a new entry to the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (top == entries.length - 1) {
            this.extendStackCapacity();
        }
        entries[top+1] = entry;
        top++;
    }

    private void extendStackCapacity() {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[entries.length * 2];
        System.arraycopy(entries, 0, temp, 0, entries.length);
        entries = temp;
    }

    /**
     * Removes and returns this stack's top entry.
     * Throws NoSuchElementException if the stack is empty.
     */
    @Override
    public E pop() {
        if(top == -1){
            throw new NoSuchElementException();
        }
        E popped = entries[top];
        entries[top] = null;
        top--;
        return popped;
    }

    /**
     * Returns the stack's top entry.
     * Throws NoSuchElementException if the stack is empty.
     */
    @Override
    public E peek() {
        if(top == -1){
            throw new NoSuchElementException();
        }
        return entries[top];
    }

    /**
     * Returns true if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Removes all entries from the stack.
     */
    @Override
    public void clear() {
        while(top != -1){
            entries[top] = null;
            top--;
        }
    }

    /**
     * Returns the number of elements in the stack.
     */
    @Override
    public int size() {
        return top+1;
    }

}
