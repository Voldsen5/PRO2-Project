package ex02;

import java.util.List;
import java.util.Set;

public interface MapI<K, V> {
	// Note: null is not allowed as a key or a value.

	/**
	* Return the value corresponding to the key.
	* Return null, if the key is not in the map.
	*/
	public V get(K key);

	/**
	 * Insert a (key, value) pair in the map.
	 * Return the old value, if the key was in the map before this insertion.
	 * If not, return null.
	 */
	public V put(K key, V value);

	/**
	 * Remove the (key, value) pair with the key as key from the map.
	 * Return the value, if the key was in the map before this removal.
	 * If not, return null.
	 */
	public V remove(K key);

	/**
	 * Return a set with all the keys in the map.
	 */
	public Set<K> keys();

	/**
	 * Return a list with all the values in the map.
	 */
	public List<V> values();

	/**
	 * Return the number of (key,value) pairs in the map.
	 */
	public int size();

	/**
	 * Return true on an empty map, false on a non-empty map.
	 */
	public boolean isEmpty();

}
