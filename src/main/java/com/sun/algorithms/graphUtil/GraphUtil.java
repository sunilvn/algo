package com.sun.algorithms.graphUtil;

import java.util.LinkedList;

import com.sun.algorithms.graphs.Graph;

public class GraphUtil {

	public static boolean isCycleForUndirected(Graph g) {
		boolean visited[] = new boolean[g.getList().length + 1];
		return isCycleForUndirected(g, visited, 1, 0);

	}

	private static boolean isCycleForUndirected(Graph g, boolean[] visited, int node, int prev) {
		// System.out.print(node + "\t");
		visited[node] = true;

		LinkedList<Integer> lLst = g.getList()[node];
		for (int aNode : lLst) {
			if (visited[aNode] && prev != aNode) {
				return true;
			}
			if (!visited[aNode]) {
				boolean flag = isCycleForUndirected(g, visited, aNode, node);
				if (flag)
					return true;
			}
		}
		return false;
	}

	public static boolean isCycleForDirected(Graph g) {
		boolean visited[] = new boolean[g.getList().length + 1];
		return isCycleForDirected(g, visited, 1);

	}

	private static boolean isCycleForDirected(Graph g, boolean[] visited, int node) {

		visited[node] = true;

		LinkedList<Integer> nodeLst = g.getList()[node];
		for (int aNode : nodeLst) {
			if (visited[aNode]) {
				return true;
			}
			boolean flag = isCycleForDirected(g, visited, aNode);
			if (flag)
				return true;
			visited[aNode] = false;
		}

		return false;
	}
}
