package com.sun.algorithms.minPQ;

import java.util.Arrays;

public class MinPriorityQueue<T> implements Comparable<T> {

	private T[] pq;
	int index;

	public MinPriorityQueue(int size) {
		pq = (T[]) new Object[size];
		index = 0;
	}

	public void insert(T data) {
		pq[++index] = data;
		bubbleUp(index);
	}

	public boolean contains(T data) {

		for (int i = 0; i < pq.length; i++) {
			if (pq[i] != null)
				if (pq[i].equals(data))
					return true;
		}
		return false;
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
		T tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = (T) tmp;

	}

	@SuppressWarnings("unchecked")
	private boolean lesser(T a, T b) {

		if (((Comparable<T>) a).compareTo(b) < 1)
			return true;
		else
			return false;
	}

	public T deleteMin() {
		T min = pq[1];
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

	public boolean isEmpty() {
		if (index == 0)
			return true;
		return false;
	}

	public int compareTo(T arg0) {

		return 0;
	}

	@Override
	public String toString() {
		return "MinPriorityQueue [pq=" + Arrays.toString(pq) + ", index=" + index + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + Arrays.hashCode(pq);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MinPriorityQueue other = (MinPriorityQueue) obj;
		if (index != other.index)
			return false;
		if (!Arrays.equals(pq, other.pq))
			return false;
		return true;
	}

}
