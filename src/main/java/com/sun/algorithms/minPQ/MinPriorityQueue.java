package com.sun.algorithms.minPQ;

import java.util.Arrays;

public class MinPriorityQueue<T> implements Comparable<T> {

	private T[] pq;
	int index;

	@SuppressWarnings("unchecked")
	public MinPriorityQueue(int size) {
		pq = (T[]) new Object[size];
		index = 0;
	}

	public void insert(T data) {
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

}
