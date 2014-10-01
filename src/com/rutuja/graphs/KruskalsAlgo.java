package com.rutuja.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.rutuja.graphs.AdjacencyList.Edge;

public class KruskalsAlgo {

	public int kruskal(AdjacencyList al) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		List<Edge> mst = new ArrayList<Edge>();
		int cost = 0;
		for (int i = 0; i < al.getTotalVertices(); i++) {
			for (Edge edge : al.getEdges(i)) {
				pq.add(edge);
			}
		}
		UnionFind uf = new UnionFind(al.getTotalVertices());

		while (!pq.isEmpty()) {

			Edge e = pq.poll();
			if (!uf.isConnected(e.getU(), e.getV())) {
				cost += e.getWeight();
				mst.add(e);
				uf.union(e.getU(), e.getV());
			}
		}
		return cost;

	}

}
