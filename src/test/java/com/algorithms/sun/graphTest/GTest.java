package com.sun.graphTest;

import com.sun.graphUtil.GraphUtil;
import com.sun.graphs.BFS;
import com.sun.graphs.DFS;
import com.sun.graphs.DiGraph;
import com.sun.graphs.Graph;
import com.sun.graphs.UnDiGraph;

public class GTest {

	public static void main(String[] args) {
		Graph g = new UnDiGraph();
		Graph g1 = new UnDiGraph();
		Graph g3 = new UnDiGraph();
		DiGraph g2 = new DiGraph();
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 20);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(20, 22);
		g.addEdge(1, 4);
		g.addEdge(3, 8);

		g1.addEdge(1, 2);
		g1.addEdge(1, 4);
		g1.addEdge(2, 6);
		//g1.addEdge(6, 8);
		g1.addEdge(2, 3);
		g1.addEdge(3, 7);
		//g1.addEdge(7, 3);
		g1.addEdge(7, 8);
		
		g2.addEdge(1, 2);
		g2.addEdge(1, 4);
		g2.addEdge(2, 6);
		//g2.addEdge(6, 8);
		g2.addEdge(2, 3);
		g2.addEdge(3, 7);
		//g2.addEdge(7, 3);
		g2.addEdge(7, 8);
		g3.addEdge(1, 2);
		//g3.addEdge(2, 3);
		//g3.addEdge(3, 3);
		//g3.addEdge(4, 1);
		System.out.println("Printing dfs for Directed graph G2....");
		new DFS(g2);
		System.out.println("\nPrinting bfs for Directed graph G2....");
		new BFS(g2);
		System.out.println("\nCycle for directed G2 "+GraphUtil.isCycleForDirected(g2));
		System.out.println("\n\nPrinting dfs for unDirected graph G1....");
		new DFS(g1);
		System.out.println("\nPrinting bfs for unDirected graph G1....");
		new BFS(g1);
		System.out.println("\n\nCycle for undirected G1 "+GraphUtil.isCycleForUndirected(g1));
		System.out.println("\n\nCycle for undirected G3 "+GraphUtil.isCycleForUndirected(g3));

	}
}
