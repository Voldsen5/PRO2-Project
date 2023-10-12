package Ex03;

public interface DequeI<E> {

    /**
     * adds en entry at the front of the deque
     */
    public void addFirst(E entry);

    /**
     * adds an entry at the back of the deque
     */
    public void addLast(E entry);

    /**
     * removes and returns the entry at the front of the deque
     */
    public E removeFirst();

    /**
     * removes and returns the entry at the back of the deque
     */
    public E removeLast();

    /**
     * returns the entry at the front of the deque
     */
    public E getFirst();

    /**
     * returns the entry at the back of the queue
     */
    public E getLast();

    /**
     * @returns true if the deque is empty
     */
    public boolean isEmpty();

    /**
     * removes all entries from the deque
     */
    public void clear();

    /**
     * returns the number of entries in the deque
     */
    public int size();
}
