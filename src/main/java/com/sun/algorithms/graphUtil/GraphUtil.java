package com.sun.algorithms.graphUtil;

import java.util.LinkedList;
import java.util.Stack;

import com.sun.algorithms.graphs.Graph;

public class GraphUtil {

	public static boolean isCycleForUndirected(Graph g) {
		boolean visited[] = new boolean[g.getList().length + 1];
		return isCycleForUndirected(g, visited, 1, 0);

	}

	public static void preOrder(Graph g) {
		boolean visited[] = new boolean[g.getList().length + 1];
		preOrder(g, 1, visited);
	}

	private static void preOrder(Graph g, int i, boolean[] visited) {
		System.out.print(i + "\t");
		visited[i] = true;
		for (int aNode : g.getList()[i]) {
			if (!visited[aNode]) {
				preOrder(g, aNode, visited);
			}
		}

	}

	public static void postOrder(Graph g) {
		boolean visited[] = new boolean[g.getList().length + 1];
		postOrder(g, 1, visited);
	}

	private static void postOrder(Graph g, int i, boolean[] visited) {
		visited[i] = true;
		for (int aNode : g.getList()[i]) {
			if (!visited[aNode]) {
				postOrder(g, aNode, visited);
			}
		}
		System.out.print(i + "\t");
	}

	public static void revPostOrder(Graph g) {
		boolean visited[] = new boolean[g.getList().length + 1];
		Stack<Integer> st=new Stack<Integer>();
		revPostOrder(g, 1, visited,st);
		while (!st.isEmpty()) {
			System.out.print(st.pop()+"\t");
		}
	}

	private static void revPostOrder(Graph g, int i, boolean[] visited,Stack<Integer> st) {
		visited[i] = true;
		for (int aNode : g.getList()[i]) {
			if (!visited[aNode]) {
				revPostOrder(g, aNode, visited,st);
			}
		}
		st.push(i);
		//System.out.print(i + "\t");
	}
	
	private static boolean isCycleForUndirected(Graph g, boolean[] visited, int node, int prev) {

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
		boolean onStack[] = new boolean[g.getList().length + 1];
		return isCycleForDirected(g, visited, onStack, 1);

	}

	/**
	 * This method has O(V+E) time complexity
	 * 
	 * @param g
	 * @param visited
	 * @param onStack
	 * @param node
	 * @return
	 */
	private static boolean isCycleForDirected(Graph g, boolean[] visited, boolean onStack[], int node) {

		visited[node] = true;

		LinkedList<Integer> nodeLst = g.getList()[node];
		for (int aNode : nodeLst) {
			if (!visited[aNode]) {
				onStack[aNode] = true;
				boolean flag = isCycleForDirected(g, visited, onStack, aNode);
				if (flag)
					return true;
				onStack[aNode] = false;
			} else if (onStack[aNode]) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This method has more that O(V+E) time complexity
	 * 
	 * @param g
	 * @param visited
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unused")
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
