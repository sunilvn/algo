package com.sun.algorithms.mst;

import java.util.Iterator;

import com.sun.algorithms.ewGraph.Edge;
import com.sun.algorithms.ewGraph.UnDiEwGraph;
import com.sun.algorithms.minPQ.MinPriorityQueue;
import com.sun.algorithms.queue.Queue;

public class PrimsMst {

	MinPriorityQueue<Edge> pq;
	boolean marked[];
	Queue<Edge> mst = new Queue<Edge>();

	public PrimsMst(UnDiEwGraph g) {
		pq = new MinPriorityQueue<Edge>(g.getEdges() + 1);
		marked = new boolean[g.adj.length + 1];
		visit(g, 1);// assuming 1 as starting point
		while (!pq.isEmpty()) {

			Edge e = pq.deleteMin();
			int v = e.either();
			int u = e.other(v);

			if (marked[v] && marked[u])
				continue;
			mst.enqueue(e);
			if (!marked[u])
				visit(g, u);
			if (!marked[v])
				visit(g, v);
		}
		Iterator<Edge> iterator = mst.iterator();
		while (iterator.hasNext()) {
			Edge type = (Edge) iterator.next();
			System.out.print(type.getWeight() + "\t");

		}
	}

	private void visit(UnDiEwGraph g, int i) {

		marked[i] = true;

		for (Edge e : g.adj[i]) {
			int w = e.other(i);
			if (!marked[w])
				pq.insert(e);
		}

	}

}
