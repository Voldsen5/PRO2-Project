package ex01B;

import ex01A.QueueI;
import ex01A.SingleLinkedQueue;

import java.util.NoSuchElementException;

public class DoubleLinkedQueue<E> implements QueueI<E> {
	// first points to the node at the front of the queue
	// (= the first node in the singly-linked list)
	private Node header;

	// last points to the node at the back of the queue
	// (= the last node in the singly-linked list)
	private Node trailer;
	private Node before;

	private int size;

	public DoubleLinkedQueue() {
		header = new Node(null);
		trailer = new Node(null);
		header.next = trailer;
		trailer.previous = header;

	}

	/**
	 * Add a new entry to the back of the queue.
	 */
	@Override
	public void add(E entry) {
		Node newNode = new Node(entry);
		if (isEmpty())
		{
			header.next = newNode;
			newNode.previous = header;
			trailer.previous = newNode;
			newNode.next = trailer;
		}
		before.next = newNode;
		newNode.previous = before;
		newNode.next = trailer;
		trailer.previous = newNode;
		before = newNode;

		size++;
	}

	/**
	 * Remove and return the entry at the front of the queue.
	 * Throw a NoSuchElementException(), if the queue is empty.
	 */
	@Override
	public E remove() {
		size--;
		if (header.next != trailer){
			header.next = header.next.next;
			return header.entry;
		}
		else throw new NoSuchElementException();
	}

	/**
	 * Return the entry at the front of the queue.
	 * Throw a NoSuchElementException(), if the queue is empty.
	 */
	@Override
	public E element() {
		if (header.entry != null){
			return header.entry;
		}
		else throw new NoSuchElementException();
	}

	/**
	 * Return true, if the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Remove all entries from this queue.
	 */
	@Override
	public void clear() {
		header = null;
		trailer = null;
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
		Node node = header.next;
		StringBuilder sb = new StringBuilder("[");
		while (node.next != trailer){
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
		private Node previous;

		public Node(E entry) {
			this.entry = entry;
		}
	}
}
