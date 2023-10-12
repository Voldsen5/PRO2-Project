package ex01A;

import javax.management.loading.ClassLoaderRepository;
import java.util.NoSuchElementException;

public class SingleLinkedQueue<E> implements QueueI<E> {
	// first points to the node at the front of the queue
	// (= the first node in the singly-linked list)
	private Node first;

	// last points to the node at the back of the queue
	// (= the last node in the singly-linked list)
	private Node last;

	private int size;

	public SingleLinkedQueue() {
		first = null;
		last = null;
	}

	/**
	 * Add a new entry to the back of the queue.
	 */
	@Override
	public void add(E entry) {
		Node newNode = new Node(entry);
		if (first == null){
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;

	}

	/**
	 * Remove and return the entry at the front of the queue.
	 * Throw a NoSuchElementException(), if the queue is empty.
	 */
	@Override
	public E remove() {
		size--;
		if (first != null){
			first = first.next;
			return first.entry;
		}
		else throw new NoSuchElementException();
	}

	/**
	 * Return the entry at the front of the queue.
	 * Throw a NoSuchElementException(), if the queue is empty.
	 */
	@Override
	public E element() {
		if (first.entry != null){
			return first.entry;
		}
		else throw new NoSuchElementException();
	}

	/**
	 * Return true, if the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (first == null && last == null){
			return true;
		}
		else return false;
	}

	/**
	 * Remove all entries from this queue.
	 */
	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;

	}

	/**
	 * Return the number of elements in the queue.
	 */
	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		Node node = first;
		StringBuilder sb = new StringBuilder("[");
		while (node != null){
			sb.append(node.entry).append(", ");
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}

	//-------------------------------------------------------------------------

	private class Node {
		private final E entry;
		private Node next;

		public Node(E entry) {
			this.entry = entry;
		}
	}
}
