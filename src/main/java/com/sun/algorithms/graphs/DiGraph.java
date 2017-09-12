package com.sun.algorithms.graphs;

import java.util.LinkedList;

public class DiGraph implements Graph {

	private LinkedList<Integer> list[];
	private int edges = 0;

	@SuppressWarnings("unchecked")
	public DiGraph() {
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
		edges++;

	}

	public int getNoEdges() {
		return edges;
	}

	public LinkedList<Integer>[] getList() {
		return list;
	}

	public void setList(LinkedList<Integer>[] list) {
		this.list = list;
	}

}
