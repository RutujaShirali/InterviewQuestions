package com.rutuja.graphs;

import java.util.Arrays;

public class UnionFind {
	private int size;
	int[] parent;

	public UnionFind(int size) {
		super();
		this.size = size;
		this.parent = new int[this.size];
		Arrays.fill(parent, -1);
	}
	
	
	private int findRoot(int u){
		if(parent[u] == -1) return u;
		return parent[u] = findRoot(parent[u]);
	}
	
	public boolean isConnected(int i, int j){
		return findRoot(i) == findRoot(j);
	}
	
	public void union(int i, int j){
		int iRoot = findRoot(i);
		int jRoot = findRoot(j);
		if(iRoot != jRoot){
			parent[jRoot] = iRoot;
		}
	}
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.union(0, 1);
		uf.union(1, 3);
		System.out.println(uf.isConnected(0, 3));
		
	}

}
