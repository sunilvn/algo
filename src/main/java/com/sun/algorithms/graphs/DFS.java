package com.sun.algorithms.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	boolean a[];
	int edge[];

	public DFS() {
	}

	/**
	 * Prints the DFS Trace
	 */
	public void dfsTrace(Graph g) {
		a = new boolean[g.getList().length + 1];
		dfsTrace(g, 1);
	}

	private void dfsTrace(Graph g, int i) {

		System.out.print(i + "\t");
		a[i] = true;

		LinkedList<Integer> lLst = g.getList()[i];
		for (int aNode : lLst) {
			if (!a[aNode]) {
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
		a = new boolean[g.getList().length + 1];
		dfsPath(g, source);
		if (source == destination) {
			System.out.println("Both source and destination are same");
		} else if (!a[destination]) {
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

		a[i] = true;

		LinkedList<Integer> lLst = g.getList()[i];
		for (int aNode : lLst) {
			if (!a[aNode]) {
				edge[aNode] = i;
				dfsPath(g, aNode);
			}
		}
	}
}
