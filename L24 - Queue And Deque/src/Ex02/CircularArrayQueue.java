package Ex02;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements QueueI<E> {

    private int size;
    private E[] entries;
    private int head;
    private int tail;

    public CircularArrayQueue() {
        this(6);
    }

    public CircularArrayQueue(int capacity) {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        entries = temp;
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public void add(E entry) {
        if(size == entries.length){
            extendStackCapacity();
        }
        if(tail == entries.length && entries[0] == null){
            tail = 0;
        }
        entries[tail] = entry;
        tail++;
        size++;
    }

    private void extendStackCapacity() {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[entries.length * 2];
        System.arraycopy(entries, 0, temp, 0, entries.length);
        entries = temp;
        tail = size;
        head = 0;
    }

    @Override
    public E remove() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E popped = entries[head];
        entries[head] = null;
        size--;
        head++;
        return popped;
    }

    @Override
    public E element() {
        return entries[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(entries, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < entries.length){
            //if(entries[i] != null){
                sb.append(i).append(" ").append(entries[i]).append("\n");
            //}
            i++;
        }
        if(sb.toString().equals("")){
            sb.append("Empty");
        }
        return sb.toString();
    }
}
