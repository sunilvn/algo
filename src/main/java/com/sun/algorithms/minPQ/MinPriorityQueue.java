package com.sun.algorithms.minPQ;

public class MinPriorityQueue<E, T> implements Comparable<T> {

	private E[] pq;
	int index;

	@SuppressWarnings("unchecked")
	public MinPriorityQueue(int size) {
		pq = (E[]) new Object[size];
		index = 0;
	}

	public void insert(E data) {
		pq[++index] = data;
		bubbleUp(index);
	}

	private void bubbleUp(int index) {
		while (index > 1) {
			if (lesser(pq[index], pq[index / 2]))
				swap(index / 2, index);
			else
				break;
			index = index / 2;
		}
	}

	private void swap(int i, int j) {
		E tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = (E) tmp;

	}

	@SuppressWarnings("unchecked")
	private boolean lesser(E a, E b) {

		if (((Comparable<T>) a).compareTo((T) b) < 1)
			return true;
		else
			return false;
	}

	public E deleteMin() {
		E min = pq[1];
		swap(1, index--);
		bubbleDown(1);
		return min;
	}

	private void bubbleDown(int i) {

		int j = 2 * i;
		while (j <= index) {

			if (lesser(pq[j + 1], pq[j]) && j < index)
				j++;
			if (lesser(pq[j], pq[i]))
				swap(i, j);
			else
				break;
			i = j;
			j = 2 * i;
		}
	}

	public void heapify() {
		int size = index;
		while (index > 1) {
			swap(1, index--);
			bubbleDown(1);
		}
		index = size;
	}

	public int compareTo(T o) {
		return 0;
	}

	public boolean isEmpty() {
		if (index == 0)
			return true;
		return false;
	}
}
