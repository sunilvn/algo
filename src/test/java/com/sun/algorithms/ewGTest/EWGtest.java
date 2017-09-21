package com.sun.algorithms.ewGTest;

import com.sun.algorithms.ewGraph.Edge;
import com.sun.algorithms.ewGraph.UnDiEwGraph;
import com.sun.algorithms.minPQ.MinPriorityQueue;
import com.sun.algorithms.mst.KruskalMst;
import com.sun.algorithms.mst.PrimsMst;

public class EWGtest {

	public static void main(String[] args) {

		MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>(50);
		pq.insert(1100);
		pq.insert(990);
		pq.insert(800);
		
		pq.insert(300);
		pq.insert(700);
		pq.insert(600);
		pq.insert(850);
		System.out.print(pq.deleteMin() + "\t");
		System.out.print(pq.deleteMin() + "\t");
		System.out.print(pq.deleteMin() + "\t");
		System.out.print(pq.deleteMin() + "\t");
		System.out.print(pq.deleteMin() + "\t");
		System.out.print(pq.deleteMin() + "\t");
		System.out.print(pq.deleteMin() + "\t");
		System.out.println();
		
		UnDiEwGraph eg = new UnDiEwGraph(8);
		eg.addEdge(new Edge(1, 7, 19));
		eg.addEdge(new Edge(1, 3, 29));
		eg.addEdge(new Edge(1, 5, 32));
		eg.addEdge(new Edge(3, 2, 17));
		eg.addEdge(new Edge(1, 2, 36));
		eg.addEdge(new Edge(2, 7, 34));
		eg.addEdge(new Edge(2, 8, 26));
		eg.addEdge(new Edge(8, 7, 16));
		eg.addEdge(new Edge(4, 8, 38));
		eg.addEdge(new Edge(4, 5, 35));
		eg.addEdge(new Edge(6, 4, 93));
		eg.addEdge(new Edge(3, 6, 52));
		eg.addEdge(new Edge(2, 6, 40));
		eg.addEdge(new Edge(8, 6, 58));
		eg.addEdge(new Edge(5, 7, 28));
		eg.addEdge(new Edge(4, 7, 37));
		new PrimsMst(eg);
		System.out.println();
		new KruskalMst(eg);

	}
}
