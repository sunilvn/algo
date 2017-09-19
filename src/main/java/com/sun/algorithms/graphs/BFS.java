package com.sun.algorithms.graphs;

import java.util.LinkedList;

import com.sun.algorithms.queue.Queue;

public class BFS {

	boolean visited[];
	int level[];

	public void bfsTrace(Graph g) {
		visited = new boolean[g.getList().length + 1];
		bfsTrace(g, 1);// assuming 1 as starting vertex
	}

	/**
	 * Find level between two vertices
	 *
	 * @param g
	 *            { undirected graph}
	 */
	public void level(Graph g, int a, int b) {
		visited = new boolean[g.getList().length + 1];
		level = new int[g.getList().length];
		level[1] = 1;
		bfsLevel(g, 1);
		if (level[a] == 0 || level[b] == 0)
			System.out.println("vertex a or b not exists in same Graph Component");
		else {
			System.out.println("\nlevel : " + Math.abs(level[a] - level[b]));
		}
	}

	private void bfsTrace(Graph g, int i) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int node = (Integer) queue.dequeue();
			System.out.print(node + "\t");
			LinkedList<Integer> nodeLst = g.getList()[node];
			for (Integer aNode : nodeLst) {
				if (!visited[aNode]) {
					visited[aNode] = true;
					queue.enqueue(aNode);
				}
			}
		}

	}

	private void bfsLevel(Graph g, int i) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int node = (Integer) queue.dequeue();
			LinkedList<Integer> nodeLst = g.getList()[node];
			for (Integer aNode : nodeLst) {
				if (!visited[aNode]) {
					level[aNode] = level[node] + 1;
					visited[aNode] = true;
					queue.enqueue(aNode);
				}
			}
		}

	}
}
