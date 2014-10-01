package com.rutuja.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.rutuja.graphs.AdjacencyList.Edge;

public class PrimsAlgo {

	public int prims(AdjacencyList al) {
		int mstLen = 0;
		boolean[] visited = new boolean[al.getTotalVertices()];
		List<Edge> mst = new ArrayList<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[1] = true;
		for (Edge edge : al.getEdges(1)) {
			pq.add(edge);
		}
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (!visited[e.getV()]) {
				mstLen += e.getWeight();
				mst.add(e);
				visited[e.getV()] = true;
				for (Edge edge : al.getEdges(e.getV())) {
					if (!visited[edge.getV()]) {
						pq.add(edge);

					}
				}
			}
		}
		System.out.println(mst);
		return mstLen;
	}

}
