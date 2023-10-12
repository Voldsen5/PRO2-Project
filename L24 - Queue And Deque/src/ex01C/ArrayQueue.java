package ex01C;


import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueI<E> {

    private int size;
    private E[] entries;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        entries = temp;
        size = 0;
    }

    @Override
    public void add(E entry) {
        if(size == entries.length){
            extendStackCapacity();
        }
        entries[size] = entry;
        size++;
    }

    private void extendStackCapacity() {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[entries.length * 2];
        System.arraycopy(entries, 0, temp, 0, entries.length);
        entries = temp;
    }

    @Override
    public E remove() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E popped = entries[0];
        for(int i = 1; i < size; i++){
            entries[i-1] = entries[i];
        }
        size--;
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
        for(int i = 0; i < size-1; i++){
            entries[i] = null;
        }
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
        while(i < size){
            sb.append(entries[i]).append("\n");
            i++;
        }
        if(sb.toString().equals("")){
            sb.append("Empty");
        }
        return sb.toString();
    }
}
