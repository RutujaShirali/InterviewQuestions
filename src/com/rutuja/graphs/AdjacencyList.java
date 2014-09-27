package com.rutuja.graphs;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class AdjacencyList {

	private int totalVertices;
	private Edge[] head;

	public AdjacencyList(int totalVertices) {
		super();
		this.totalVertices = totalVertices;
		head = new Edge[totalVertices];
	}

	class Edge {
		private int u, v;
		private Edge next;

		public Edge(int u, int v, Edge next) {
			super();
			this.u = u;
			this.v = v;
			this.next = next;
		}

	}

	public void addEdge(int u, int v) {
		head[u] = new Edge(u, v, head[u]);
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
	
	public boolean isConnected(int u , int v){
		if(containsEdge(u, v)) return true;
		for(Edge edge : getEdges(u) ){
			if(isConnected(edge.v,v)) return true;
		}
		return false;
		}
	
	public void dfs(int u){
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

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File(
				"C:\\Users\\Rutuja\\Desktop\\edges.txt"));
		int vertices = scan.nextInt();
		AdjacencyList al = new AdjacencyList(vertices);
		while (scan.hasNext()) {
			al.addEdge(scan.nextInt(), scan.nextInt());
		}
		System.out.println(al);
		al.dfs(1);
		System.out.println(al.isConnected(3, 0));
		System.out.println(al.containsEdge(1, 3));

	}

}
