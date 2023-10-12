package Ex05;

import java.util.NoSuchElementException;

public class ArrayDropoutStack<E> implements StackI<E> {
    // the index of the top entry in the stack,
    // top is -1 if the stack is empty
    private int top;
    // contains the entries in the stack
    private E[] entries;
    private int capacity;

    public ArrayDropoutStack(int capacity) {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.capacity = capacity;
        entries = temp;
        top = -1;
    }

    /**
     * Adds a new entry to the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (top == capacity-1) {
            this.dropOut();
        }
        entries[top+1] = entry;
        top++;
    }

    public void dropOut(){
        for(int i = 1; i < entries.length; i++){
            entries[i-1] = entries[i];
        }
        top--;
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
    @Override
    public void print(){
        for(int i = top; i >= 0; i--){
            System.out.println(entries[i]);
        }
    }
}
