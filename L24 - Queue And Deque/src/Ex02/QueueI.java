package Ex02;

public interface QueueI<E> {

    /**
     * Add a new entry to the back of the queue.
     */
    public void add(E entry);

    /**
     * Remove and return the entry at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    public E remove();

    /**
     * Return the entry at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    public E element();

    /**
     * Return true, if the queue is empty.
     */
    public boolean isEmpty();

    /**
     * Remove all entries from the queue.
     */
    public void clear();

    /**
     * Return the number of elements in the queue.
     */
    public int size();

}
