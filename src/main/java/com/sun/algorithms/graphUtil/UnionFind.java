package com.sun.algorithms.graphUtil;

public class UnionFind {

	int parent[];
	int size[];

	public UnionFind(int inSize) {

		parent = new int[inSize];
		size = new int[inSize];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
	}

	public int find(int i) {

		if (parent[i] == -1)
			return i;
		return find(parent[i]);
	}

	public boolean isConnected(int v, int w) {
		return find(v) == find(w);
	}

	public void union(int v, int w) {

		if (isConnected(v, w))
			return;

		int rootv = find(v);
		int rootw = find(w);

		if (size[rootv] <= size[rootw]) {
			parent[rootv] = rootw;
			size[rootv] += size[rootw];
		} else {
			parent[rootw] = rootv;
			size[rootw] += rootv;
		}
	}
}
