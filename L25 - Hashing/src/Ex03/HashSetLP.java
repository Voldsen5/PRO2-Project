package Ex03;

/**
 * HashSetLP implements a hash set using linear probing.
 * Note: null is not allowed as an element in the set.
 */
public class HashSetLP<E> {
    // the hash table
    private E[] table;
    // the number of elements in the hash set
    private int size;
    // the special value used to mark an earlier occupied entry as free
    @SuppressWarnings("unchecked")
    private final E deleted = (E) new Object();

    /**
     * Create a new HashSetLP with the given table length.
     */
    public HashSetLP(int tableLength) {
        @SuppressWarnings("unchecked")
        E[] emptyTable = (E[]) new Object[tableLength];
        table = emptyTable;
        size = 0;
    }

    private int hash(E element) {
        int h = element.hashCode();
        if (h < 0) h = -h;
        h = h % table.length;
        return h;
    }

    /**
     * Return true, if element is in the set.
     */
    public boolean contains(E element) {
        if(size == 0){
            return false;
        }

        int hash = hash(element);
        while(table[hash] != null){
            if(table[hash] == element){
                return true;
            }
            hash++;
        }
        return false;
    }

    /**
     * Add element to the set.
     * Returns true, if the element is added to the set.
     * Throw IllegalArgumentException, if element is null.
     */
    public boolean add(E element) {
        if(element == null){
            throw new IllegalArgumentException();
        }

        int hash = hash(element);
        int originalHash = hash; //because the array can be full due to no extend function
        int i = 0;
        while(table[hash+i] != null && table[hash+i] != deleted){
            i++;
            if(hash+i >= table.length){
                hash = 0;
                i = 0;
            }
            if(hash+i == originalHash){
                return false;
            }
        }
        table[hash+i] = element;
        size++;
        return true;
    }

    /**
     * Remove element from the set.
     * Returns true, if the element is removed from the set.
     */
    public boolean remove(E element) {
        int hash = hash(element);
        int originalHash = hash; // to stop the loop if the element isn't in the list
        int i = 0;
        while(table[hash+i] != null){
            if(table[hash+i] == element){
                table[hash+i] = deleted;
                size--;
                return true;
            }
            i++;
            if(hash + i == originalHash){
                return false;
            }
        }
        return false;
    }

    /**
     * Return the number of elements in the set.
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while(i<table.length){
            if(table[i] != null && table[i] != deleted){
                sb.append(", ").append(table[i]);
            }
            i++;
        }
        sb.delete(1,3);
        sb.append("]");
        return sb.toString();
    }
}
