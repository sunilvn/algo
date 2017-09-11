package com.sun.queue;

public class Queue {

	private Node first;
	private Node last;
	private int size;

	public void enqueue(int data) {

		Node node = new Node(data);
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

	public int dequeue() {

		if (isEmpty()) {
			System.out.print("Queue is empty returning with -1");
			return -1;
		} else {
			int data;
			if (first == last) {
				data = first.getData();
				first = null;
				last = null;
				size--;
			} else {
				data = first.getData();
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
}
