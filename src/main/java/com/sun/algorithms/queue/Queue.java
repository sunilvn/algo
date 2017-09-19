package com.sun.algorithms.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

	private Node<?> first;
	private Node<?> last;
	private int size;

	public void enqueue(T data) {

		Node<T> node = new Node<T>(data);
		if (first == null && last == null) {
			first = node;
			last = node;
			size++;
		} else {
			last.setNext(node);
			last = node;
			size++;
		}
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {

		if (isEmpty()) {
			System.out.print("Queue is empty returning with -1");
			return null;
		} else {
			T data;
			if (first == last) {
				data = (T) first.getData();
				first = null;
				last = null;
				size--;
			} else {
				data = (T) first.getData();
				first = first.getNext();
				size--;
			}
			return data;
		}
	}

	public boolean isEmpty() {
		if (first == null || last == null || size == 0)
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
