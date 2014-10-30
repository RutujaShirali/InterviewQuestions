package com.rutuja.lists;

public class LLQuestions {

	private class Node {
		private int value;
		private Node next;

		public Node(int n, Node next) {
			this.value = n;
			this.next = next;
		}

		public Node(int n) {
			this(n, null);
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return String.format("(%d,%s)", value, next);
		}

	}

	public Node findIntersection(Node head1, Node head2) {
		Node node = head1;
		Node n1 = head2, n2 = head2;
		int count = 1;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		node.next = head1;
		for (int i = 0; i < count; i++) {
			n1 = n1.next;
		}
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		node.next = null;
		return n1;

	}

	public Node findLoopList(Node h) {
		Node node = h;
		Node slow = h, fast = h;
		Node loopNode = null;
		while (fast != null) {
			slow = slow.next;
			if (fast.next == null)
				return null;
			fast = fast.next.next;
			if (slow == fast) {
				loopNode = slow;
				break;
			}
		}
		if (loopNode == null)
			return null;
		slow = loopNode.next;
		int count = 0;
		while (slow != loopNode) {
			slow = slow.next;
			count++;
		}
		slow = h;
		for (int i = 0; i < count + 1; i++) {
			node = node.next;
		}
		while (slow != node) {
			slow = slow.next;
			node = node.next;
		}
		for (int i = 0; i < count; i++) {
			slow = slow.next;
		}
		slow.next = null;
		return node;

	}

	public static void main(String[] args) {
		new LLQuestions().testListIntersection();
		new LLQuestions().testListLoop();
	}

	private Node findLast(Node h1) {
		Node node = h1;
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}

	private void testListLoop() {
		Node h1 = makeList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		Node last = findLast(h1);
		last.next = at(h1, 4);
		System.out.println(findLoopList(h1).value);
		System.out.println(h1);

	}

	private Node makeList(int[] arr) {
		Node h = null;
		for (int i = arr.length - 1; i >= 0; i--)
			h = new Node(arr[i], h);
		return h;
	}

	private Node at(Node h, int index) {
		while (h != null & index-- > 0)
			h = h.next;
		return h;
	}

	private void testListIntersection() {
		Node h1 = makeList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		Node h2 = makeList(new int[] { 9, 8 });
		append(h2, at(h1, 4));
		System.out.println(h1);
		System.out.println(h2);
		Node intersect = findIntersection(h1, h2);
		System.out.println(intersect);
	}

	private Node append(Node h, Node n) {
		if (h == null)
			return n;
		Node i = h;
		while (i.next != null)
			i = i.next;
		i.next = n;
		return h;
	}

}
