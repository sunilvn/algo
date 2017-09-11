package com.sun.graphs;

import java.util.LinkedList;

import com.sun.queue.Queue;

public class BFS {

	boolean flag[];

	public BFS(Graph g) {
		flag = new boolean[101];
		bfsTrace(g, 1);
	}

	private void bfsTrace(Graph g,
			int i) {/*
					 * 
					 * if (!flag[i]) { System.out.print(i + "\t"); flag[i] =
					 * true; } LinkedList<Integer> lLst = g.getList().get(i);
					 * for (int node : lLst) { if (!flag[node]) {
					 * System.out.print(node + "\t"); flag[node] = true; } } for
					 * (int node : lLst) {
					 * 
					 * bfsTrace(g, node); }
					 */
		// System.out.print(i + "\t");

		Queue queue = new Queue();
		queue.enqueue(i);
		while (!queue.isEmpty()) {
			int node = queue.dequeue();
			if (!flag[node]) {
				System.out.print(node + "\t");
				flag[node] = true;
			}
			LinkedList<Integer> nodeLst = g.getList()[node];
			for (Integer childNode : nodeLst) {
				if (!flag[childNode]) {
					queue.enqueue(childNode);
				}
			}
		}

	}
}
