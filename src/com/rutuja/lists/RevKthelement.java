package com.rutuja.lists;

public class RevKthelement {
	Node head;

	class Node {
		public Node(int n) {
			value = n;
		}

		int value;
		Node next;
	}

	public boolean insertFirst(int element) {
		Node first = new Node(element);
		first.next = head;
		head = first;
		return true;
	}

	private Node reverseK(Node node, int k) {
		if (node == null)
			return null;
		Node start = node; // 1 2 3 ... 8 9 10
		Node end = node;
		Node tail;
		for (int i = 0; i < k - 1 && end.next != null; i++) {
			end = end.next;
		}
		// start = 1, end = 3
		Node temp = reverseK(end.next, k); // 4 ->
		end.next = null; // start..end = 1 -> 2 -> 3 -> null
		tail = start;
		Node newHead = reversal(start);
		tail.next = temp;
		return newHead;
	}

	public void reverseK(int k) {
		if (k >1) head = reverseK(head, k);
	}

	public Node reversal(Node node) {
		Node newNode;
		Node newHead = null;
		while (node != null) {
			newNode = node;
			node = node.next;
			newNode.next = newHead;
			newHead = newNode;
		}
		return newHead;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		for (Node node = head; node != null; node = node.next) {
			if (node != head)
				sb.append(",");
			sb.append(node.value);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		RevKthelement rev = new RevKthelement();
		for (int i = 10; i > 0; i--) {
			rev.insertFirst(i);
		}
		rev.print();
		rev.reverseK(4);
		rev.print();
	}

}
