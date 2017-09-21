package com.sun.algorithms.mst;

import java.util.Iterator;

import com.sun.algorithms.ewGraph.Edge;
import com.sun.algorithms.ewGraph.EwGraph;
import com.sun.algorithms.graphUtil.UnionFind;
import com.sun.algorithms.minPQ.MinPriorityQueue;
import com.sun.algorithms.queue.Queue;

public class KruskalMst {

	MinPriorityQueue<Edge> mPQ;
	boolean marked[];
	Queue<Edge> mst;
	UnionFind uf;

	public KruskalMst(EwGraph g) {
		mPQ = new MinPriorityQueue<Edge>(g.getEdges() * 2);
		mst = new Queue<Edge>();
		uf = new UnionFind(g.getVert());

		for (int i = 0; i < g.getVert(); i++) {
			for (Edge edge : g.getAdjList()[i]) {
				int w = edge.other(i);
				if (mPQ.contains(edge))
					continue;
				mPQ.insert(edge);
			}
		}

		while (!mPQ.isEmpty()) {

			Edge ed = mPQ.deleteMin();

			int v = ed.either();
			int w = ed.other(v);

			if (uf.isConnected(v, w))
				continue;
			uf.union(v, w);
			mst.enqueue(ed);
		}

		Iterator<Edge> itr = mst.iterator();
		while (itr.hasNext()) {
			Edge ed = (Edge) itr.next();
			System.out.print(ed.getWeight() + "\t");
		}

	}
}
