package com.sun.algorithms.graphs;

import java.util.LinkedList;

public interface Graph {

	public void addEdge(int from, int to);

	public LinkedList<Integer>[] getList();
}
