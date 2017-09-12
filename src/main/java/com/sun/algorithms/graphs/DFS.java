package com.sun.algorithms.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	boolean visited[];
	boolean color[];
	int edge[];

	public DFS() {
	}

	/**
	 * Prints the DFS Trace
	 */
	public void dfsTrace(Graph g) {
		visited = new boolean[g.getList().length + 1];
		dfsTrace(g, 1);
	}

	private void dfsTrace(Graph g, int i) {

		System.out.print(i + "\t");

		LinkedList<Integer> lLst = g.getList()[i];
		for (int aNode : lLst) {
			if (!visited[aNode]) {
				visited[aNode] = true;
				dfsTrace(g, aNode);
			}
		}
	}

	/**
	 * Find path between source and destination using DFS This is NOT shortest
	 * path...!!!
	 */
	public void dfsPath(Graph g, int source, int destination) {
		edge = new int[g.getList().length];
		visited = new boolean[g.getList().length + 1];
		dfsPath(g, source);
		if (source == destination) {
			System.out.println("Both source and destination are same");
		} else if (!visited[destination]) {
			System.out.println("source " + source + " has no path to destination " + destination);
		} else {
			Stack<Integer> st = new Stack<Integer>();
			for (int i = destination; i != source; i = edge[i]) {
				st.push(i);
			}
			st.push(source);
			System.out.print("Path between source and destination : ");
			while (!st.isEmpty())
				System.out.print("\t" + st.pop());
		}

	}

	private void dfsPath(Graph g, int i) {

		LinkedList<Integer> lLst = g.getList()[i];
		for (int aNode : lLst) {
			if (!visited[aNode]) {
				edge[aNode] = i;
				visited[aNode] = true;
				dfsPath(g, aNode);
			}
		}
	}

	public boolean isTwoColorable(Graph g) {
		color = new boolean[g.getList().length + 1];
		visited = new boolean[g.getList().length + 1];
		return isTwoColorable(g, 1);
	}

	private boolean isTwoColorable(Graph g, int node) {
		visited[node] = true;
		LinkedList<Integer> lst = g.getList()[node];
		for (int aNode : lst) {

			if (!visited[aNode]) {

				color[aNode] = !color[node];
				boolean flag = isTwoColorable(g, aNode);
				if (!flag)
					return flag;
			} else {
				if (color[aNode] == color[node])
					return false;
			}
		}
		return true;
	}
}
