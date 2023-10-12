package ex02;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.prefs.NodeChangeEvent;

/**
 * LinkedMap<K,V> implements the MapI<K,V> interface using linked nodes.
 * Note: null is not allowed as a key or a value.
 */
public class LinkedMap<K, V> implements MapI<K, V> {
	private Node<K, V> head;
	private int size;

	public LinkedMap() {
		head = null;
		size = 0;
	}

	//-------------------------------------------------------------------------
	// Map<K,V> methods

	/**
	 * Return the value corresponding to the key k.
	 * Return null, if the key is not in the map.
	 */
	@Override
	public V get(K key) {
		Node<K, V> node = head;
		while (node != null){
			if (node.key == key){
				return node.value;
			}
			node = node.next;
		}
		return null;
	}

	/**
	 * Insert a (key, value) pair in the map.
	 * Return the old value, if the key was in the map before this insertion.
	 * If not, return null.
	 */
	@Override
	public V put(K key, V value) {
		Node<K,V> newNode = new Node<>(key, value);
		// guard for empty map
		if (isEmpty()) {
			head = newNode;
			size++;
			return null;
		}

		// guard for key found in first node
		if (head.key.equals(newNode.key)) {
			V v = head.value;
			newNode.next = head.next;
			head = newNode;
			return v;

		}

		Node <K,V> node = head;
		while (node.next != null) {
			if (node.next.key.equals(newNode.key)){
				V v = node.next.value;
				newNode.next = node.next.next;
				node.next = newNode;
				return v;
			}
			node = node.next;
		}

		newNode.next = head;
		head = newNode;
		size++;
		return null;
	}

	/**
	 * Remove the (key, value) pair with the key as key from the map.
	 * Return the value, if the key was in the map before this removal.
	 * If not, return null.
	 */
	@Override
	public V remove(K key) {
		// guard for empty map
		if (isEmpty()) return null;

		// guard for key found in first node
		if (head.key.equals(key)){
			V v = head.value;
			head = head.next;
			size--;
			return v;
		}

		Node <K,V> node = head;
		while (node.next != null){
			if (node.next.key.equals(key)){
				V v = node.next.value;
				node.next = node.next.next;
				size--;
				return v;
			}
			node = node.next;
		}


		return null;
	}

	/**
	 * Return a set with all the keys in the map.
	 */
	@Override
	public Set<K> keys() {
		Set<K> keys = new LinkedHashSet<K>();
		Node<K, V> node = head;
		while (node != null){
			keys.add(node.key);
			node = node.next;
		}

		return keys;
	}

	/**
	 * Return a list with all the values in the map.
	 */
	@Override
	public List<V> values() {
		List<V> values = new LinkedList<V>();
		Node<K, V> node = head;
		while (node != null){
			values.add(node.value);
			node = node.next;
		}
		return values;
	}

	/**
	 * Return the number of (key,value) pairs in the map.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Return true on an empty map, false on a non-empty map.
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	//-------------------------------------------------------------------------

	private static class Node<K, V> {
		private final K key;
		private final V value;
		private Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

}
