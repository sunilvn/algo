package com.sun.algorithms.queue;

public class Node<T> {

	private Node<?> next;
	private T data;

	public Node() {
	}

	public Node(T data) {
		this.data = data;
	}

	public Node<?> getNext() {
		return next;
	}

	public void setNext(Node<?> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [next=" + next + ", data=" + data + "]";
	}
}
