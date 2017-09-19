package com.sun.algorithms.ewGraph;

import java.util.LinkedList;

public class UnDiEwGraph implements EwGraph {

	private int vert;
	private int edges;
	public LinkedList<Edge> adj[];

	@SuppressWarnings("unchecked")
	public UnDiEwGraph(int size) {
		adj = new LinkedList[size+1];
		for (int i = 0; i < size + 1; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	public void addEdge(Edge e) {

		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		edges++;
	}

	public int getEdges() {
		return edges;
	}

	public void setEdges(int edges) {
		this.edges = edges;
	}

}
