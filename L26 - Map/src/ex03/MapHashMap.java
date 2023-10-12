package ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * MapHashMap implements the MapI interface.
 * Note: null is not a valid key or a valid value.
 * Note: Keys must obey the contract for hashCode(), that is,
 *       if k1.equals(k2) is true, then k1.hashCode() == k2.hashCode().
 * Note: Keys used in a HashMap must be immutable
 *       (more precisely: a change in a key must not change the hashCode()).
 */
public class MapHashMap<K, V> implements MapI<K, V> {
    // capacity is the size of the hash table
    private final int capacity;
    // table is the hash table
    private final HashMap<K, V>[] table;

    public MapHashMap() {
        capacity = 11;
        @SuppressWarnings("unchecked")
        HashMap<K, V>[] emptyTable = new HashMap[capacity];
        table = emptyTable;

        // fill the table with empty HashMaps
        for (int i = 0; i < table.length; i++) {
            table[i] = new HashMap<>();
        }
    }

    // hash function
    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    //-------------------------------------------------------------------------
    // Map<K,V> methods

    /**
     * Return the value corresponding to the key.
     * Return null, if the key is not in the map.
     */
    @Override
    public V get(K key) {
        int hash = hash(key);
        V v = table[hash].get(key);
        return v;
    }

    /**
     * Insert a (key, value)-pair in the map.
     * Return the old value, if the key was in the map before this insertion.
     * If not, return null.
     */
    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        return table[hash].put(key,value);
    }

    /**
     * Remove the (key, value)-pair with the key as key from the map.
     * Return the value, if the key was in the map before this removal.
     * If not, return null.
     */
    @Override
    public V remove(K key) {
        int hash = hash(key);
        return table[hash].remove(key);
    }

    /**
     * Return a set with all the keys in the map.
     */
    @Override
    public Set<K> keys() {
        Set<K> keys = new LinkedHashSet<>();

        for (HashMap<K,V>  k : table){
            keys.addAll(k.keySet());
        }

        return keys;
    }

    /**
     * Returns a list with all the values in the map.
     */
    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();

        for (HashMap<K,V> v : table){
            values.addAll(v.values());
        }

        return values;
    }

    /**
     * Return the number of (key,value)-pairs in the map.
     */
    @Override
    public int size() {
        int size = 0;

        for (HashMap<K,V> k : table){
            size = size + k.size();
        }

        return size;
    }

    /**
     * Return true on an empty map, false on a non-empty map.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

}
