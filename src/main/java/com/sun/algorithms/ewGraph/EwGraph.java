package com.sun.algorithms.ewGraph;

import java.util.LinkedList;

public interface EwGraph {


	public void addEdge(Edge e);

	public int getEdges();

	public int getVert();
	
	public LinkedList<Edge>[] getAdjList();
}
