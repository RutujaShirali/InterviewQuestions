package com.rutuja.hashmap;

public class MyHashmap {

	class Node {
		private KeyValue obj;
		private Node next;

		public Node(KeyValue obj, Node next) {
			super();
			this.obj = obj;
			this.next = next;
		}

	}

	class KeyValue {
		private Object key;
		private Object value;

		public KeyValue(Object key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	int N = 100;
	private Node[] arr;
	private int size = 0;

	public MyHashmap(int n) {
		super();
		N = n;
		arr = new Node[N];
	}

	public int size() {
		return size;
	}

	public boolean add(Object key, Object value) {
		int hash = key.hashCode() % N;
		if (hash < 0)
			hash = hash + N;
		Node head = arr[hash];
		while (head != null && !head.obj.key.equals(key)) {
			head = head.next;
		}
		if (head == null) {
			arr[hash] = new Node(new KeyValue(key, value), arr[hash]);
			size++;
		} else {
			head.obj.value = value;
		}
		return head == null;
	}

	public static void main(String[] args) {
		MyHashmap mh = new MyHashmap(10);
		mh.add(1, "Gaurav");
		mh.add(2, "Gaurav");
		mh.add(1, "Rutuja");
		mh.add(3, "Debo");
		System.out.println(mh.size());
		System.out.println(mh.getValue(100));
	}

	public Object getValue(Object key) {
		int hash = key.hashCode() % N;
		if (hash < 0)
			hash = hash + N;
		Node head = arr[hash];
		while (head != null && !head.obj.key.equals(key)) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		return head.obj.value;
	}

}
