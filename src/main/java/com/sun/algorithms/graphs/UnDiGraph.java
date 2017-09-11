package com.sun.algorithms.graphs;

import java.util.LinkedList;

public class UnDiGraph implements Graph {

	private LinkedList<Integer> list[];
	private int size = 0;

	public UnDiGraph() {
		list = new LinkedList[100];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int from, int to) {
		/*
		 * if (list. == null) { addVertex(from); } if (list.get(to) == null) {
		 * addVertex(to); }
		 */
		list[from].add(to);
		list[to].add(from);

	}

	public int getSize() {
		return size;
	}

	public LinkedList<Integer>[] getList() {
		return list;
	}

	public void setList(LinkedList<Integer>[] list) {
		this.list = list;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
