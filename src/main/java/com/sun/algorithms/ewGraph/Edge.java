package com.sun.algorithms.ewGraph;

public class Edge implements Comparable<Object> {

	private int v;
	private int w;
	private int weight;

	public Edge() {
	}

	public Edge(int v, int w, int weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either() {
		return v;
	}

	public int other(int x) {
		if (x == w)
			return v;
		return w;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/*
	 * public int compareTo(Edge e) { if (this.weight > e.getWeight()) return 1;
	 * else if (this.weight < e.getWeight()) return -1; else return 0; }
	 */

	public int compareTo(Object e) {
		if (this.weight > ((Edge) e).getWeight())
			return 1;
		else if (this.weight < ((Edge) e).getWeight())
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}
}
