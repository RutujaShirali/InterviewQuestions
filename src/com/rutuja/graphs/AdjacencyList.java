package com.rutuja.graphs;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class AdjacencyList {

	private int totalVertices;
	private Edge[] head;
	private boolean directed;
	private int[] inDegree, outDegree;
	private boolean[] used;

	public boolean[] getUsed() {
		return used;
	}

	public void setUsed(boolean[] used) {
		this.used = used;
	}

	public int[] getOutDegree() {
		return outDegree;
	}

	public void setOutDegree(int[] outDegree) {
		this.outDegree = outDegree;
	}

	public int[] getInDegree() {
		return Arrays.copyOf(inDegree, inDegree.length);
	}

	public void setInDegree(int[] inDegree) {
		this.inDegree = inDegree;
	}

	public int getTotalVertices() {
		return totalVertices;
	}

	public void setTotalVertices(int totalVertices) {
		this.totalVertices = totalVertices;
	}

	public AdjacencyList(int totalVertices, boolean directed) {
		super();
		this.totalVertices = totalVertices;
		head = new Edge[this.totalVertices];
		this.directed = directed;
		inDegree = new int[totalVertices];
		outDegree = new int[totalVertices];
		used = new boolean[totalVertices];
	}

	public class Edge implements Comparable<Edge> {
		private int u, v;
		private Edge next;
		private int weight;

		public int getU() {
			return u;
		}

		public void setU(int u) {
			this.u = u;
		}

		public int getV() {
			return v;
		}

		public void setV(int v) {
			this.v = v;
		}

		public Edge getNext() {
			return next;
		}

		public void setNext(Edge next) {
			this.next = next;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Edge(int u, int v, Edge next, int weight) {
			super();
			this.u = u;
			this.v = v;
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge other) {
			if (this.weight > other.weight)
				return 1;
			else
				return -1;
		}

		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", weight=" + weight + "]";
		}

	}

	public void addEdge(int u, int v, int weight) {
		head[u] = new Edge(u, v, head[u], weight);
		inDegree[v] += 1;
		outDegree[u] += 1;
		used[u] = true;
		used[v] = true;
		if (!directed) {
			head[v] = new Edge(v, u, head[v], weight);
		}
	}

	public boolean containsEdge(int u, int v) {
		Edge edge = head[u];
		while (edge != null) {
			if (edge.v == v)
				return true;
			edge = edge.next;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < head.length; i++) {
			for (Edge edge : getEdges(i)) {
				sb.append("(");
				sb.append(edge.u);
				sb.append(",");
				sb.append(edge.v);
				sb.append(",");
				sb.append(edge.weight);
				sb.append(")->");
			}
			if (head[i] != null)
				sb.append("+\n");
		}
		return sb.toString();

	}

	public Iterable<Edge> getEdges(int u) {
		return new EdgeIterable(u);
	}

	class EdgeIterable implements Iterable<Edge> {

		int u;

		public EdgeIterable(int u) {
			this.u = u;
		}

		@Override
		public Iterator<Edge> iterator() {
			return new EdgeIterator(u);
		}

	}

	class EdgeIterator implements Iterator<Edge> {
		Edge edge;

		public EdgeIterator(int u) {
			edge = head[u];
		}

		@Override
		public boolean hasNext() {
			return edge != null;
		}

		@Override
		public Edge next() {
			Edge temp = edge;
			edge = edge.next;
			return temp;
		}

	}

	public void bfs(int u) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		q.add(u);
		while (!q.isEmpty()) {
			u = q.poll();
			System.out.println(u);
			visited.add(u);
			Edge edge = head[u];
			while (edge != null) {
				if (!visited.contains(edge.v)) {
					q.add(edge.v);
				}
				edge = edge.next;
			}

		}

	}

	public boolean isConnected(int u, int v) {
		if (containsEdge(u, v))
			return true;
		for (Edge edge : getEdges(u)) {
			if (isConnected(edge.v, v))
				return true;
		}
		return false;
	}

	public void dfs(int u) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		stack.push(u);
		while (!stack.isEmpty()) {
			u = stack.pop();
			System.out.println(u);
			visited.add(u);
			Edge edge = head[u];
			while (edge != null) {
				if (!visited.contains(edge.v)) {
					stack.push(edge.v);
				}
				edge = edge.next;
			}

		}

	}

	public void topologicalSort(AdjacencyList al) {
		int[] inDegree = al.getInDegree();
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < al.totalVertices; i++) {
			if (al.used[i] && inDegree[i] == 0) {
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int u = stack.pop();
			System.out.println(u);
			Edge edge = head[u];
			while (edge != null) {
				inDegree[edge.v] -= 1;
				if (inDegree[edge.v] == 0) {
					stack.push(edge.v);
				}
				edge = edge.next;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File(
				"C:\\Users\\Rutuja\\Desktop\\edges.txt"));
		int vertices = scan.nextInt();
		AdjacencyList al = new AdjacencyList(vertices, true);
		DijkstrasAlgo da = new DijkstrasAlgo();
		PrimsAlgo pa = new PrimsAlgo();
		KruskalsAlgo ka = new KruskalsAlgo();
		while (scan.hasNext()) {
			al.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		scan.close();
		System.out.println(al);
		al.topologicalSort(al);
		// System.out.println(da.findDistance(1, 5, al));
		// System.out.println(pa.prims(al));
		// System.out.println(ka.kruskal(al));

	}

}
