package Ex02;

public interface StackI<E> {
    /**
     * Add a new entry to the top of the stack.
     */
    void push(E entry);

    /**
     * Remove and return the stack's top entry.
     * Throw NoSuchElementException, if the stack is empty.
     */
    E pop();

    /**
     * Return the stack's top entry.
     * Throw NoSuchElementException, if the stack is empty.
     */
    E peek();

    /**
     * Return true, if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Remove all entries from the stack.
     */
    void clear();

    /**
     * Return the number of elements in the stack.
     */
    int size();
}
