package com.sun.graphs;

import java.util.LinkedList;

public class DFS {

	boolean a[];

	public DFS(Graph g) {
		a = new boolean[101];
		dfsTrace(g, 1);
	}

	private void dfsTrace(Graph g, int i) {

			System.out.print(i+"\t");
			a[i]=true;
		
		LinkedList<Integer> lLst=g.getList()[i];
		for ( int aNode: lLst) {
			if (!a[aNode]) {
			dfsTrace(g, aNode);
			}
		}
	}
}
