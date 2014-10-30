package com.rutuja.lists;

import java.util.Stack;

public class LinkedList {
	Node head;
	Node tail;

	class Node {
		int value;
		Node next;

		public Node(int n) {
			this.value = n;
		}

	}

	public boolean insertFirst(int element) {
		Node first = new Node(element);
		if (head == null) {
			head = first;
			tail = first;
		} else {
			first.next = head;
			head = first;
		}
		return true;
	}

	public boolean insertLast(int element) {
		Node last = new Node(element);
		if (head == null) {
			head = tail = last;
		} else {
			tail.next = last;
			tail = last;
		}
		return true;
	}

	public boolean insertAtk(int k, int element) {
		if (k < 0)
			return false;
		Node node = new Node(element);
		Node n = head;
		Node prev = null;
		for (int i = 0; i < k; i++) {
			if (n == null)
				return false;
			prev = n;
			n = n.next;
		}
		if (prev == null) {
			head = tail = node;
		} else if (prev.next == null) {
			tail = node;
			prev.next = node;
		} else {
			prev.next = node;
		}
		node.next = n;
		return true;

	}

	public int size() {
		int count = 0;
		for (Node node = head; node != null; node = node.next) {
			count += 1;
		}
		return count;
	}

	public int popFirst() {
		if (head == null)
			return -1;
		else {
			int val = head.value;
			head = head.next;
			if (head == null)
				tail = null;
			return val;
		}
	}

	public int popLast() {
		if (head == null)
			return -1;
		else {
			Node node = head;
			Node prev = null;
			int val = tail.value;
			while (node.next != null) {
				prev = node;
				node = node.next;
			}
			tail = prev;
			if (tail != null)
				tail.next = null;
			else
				head = null;
			return val;
		}
	}

	public int popAtk(int k) {
		int val = -1;
		if (k < 0 || head == null)
			return -1;
		Node prev = null, next = null;
		Node n = head;
		for (int i = 0; i < k; i++) {
			if (n == null)
				return -1;
			prev = n;
			n = n.next;
		}
		val = n.value;
		if (n == head) {
			head = n.next;
			if (head == null)
				tail = null;
		} else if (n == tail) {
			tail = prev;
			tail.next = null;
		} else {

			next = n.next;
			prev.next = next;
			n.next = null;
		}
		return val;
	}

	public void reverseList() {
		Node newNode, newHead, node;
		newHead = null;
		newNode = head;
		while (newNode != null) {
			node = newNode.next;
			newNode.next = newHead;
			newHead = newNode;
			newNode = node;
		}
		head = newHead;

	}

	public void reverseList_R() {
		head = reverseList_R(head);
	}

	private Node reverseList_R(Node h) {
		Node node = h;
		if (h == null || h.next == null)
			return h;
		Node newHead = reverseList_R(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}

	public boolean isLoop() {
		Node slow = head, fast = head;
		while (fast != null) {
			slow = slow.next;
			if (fast.next == null)
				return false;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public boolean isPalindrome() {
		Stack<Integer> check = new Stack<>();
		Node node1 = head;
		Node node2 = head;
		while (node1 != null) {
			check.push(node1.value);
			node1 = node1.next;
		}
		while (node2 != null) {
			if (check.pop() != node2.value)
				return false;
			node2 = node2.next;
		}
		return true;
	}

	private Node insert(Node h, Node n) {
		if (h == null)
			return n;
		if (n.value < h.value) {
			n.next = h;
			return n;
		} else {
			Node i = h;
			Node prev = null;
			while (i != null && n.value >= i.value) {
				prev = i;
				i = i.next;
			}
			prev.next = n;
			n.next = i;
			return h;
		}
	}

	public void insertSorted(int element) {
		if (head == null)
			head = tail = new Node(element);
		else if (head.value > element)
			insertFirst(element);
		else if (tail.value < element)
			insertLast(element);
		else
			head = insert(head, new Node(element));
	}

	public void sort() {
		if (head != null) {
			Node sortedHead = null, temp = null;
			for (Node n = head; n != null; n = temp) {
				temp = n.next;
				n.next = null;
				sortedHead = insert(sortedHead, n);
			}
			head = tail = sortedHead;
			while (tail.next != null) {
				tail = tail.next;
			}
		}
	}

	public void removeDups() {
		sort();
		Node node = head;
		Node next = null;
		while (node != null) {
			next = node.next;
			if (next == null)
				break;
			if (next.value == node.value) {
				node.next = next.next;
			} else {
				node = next;
			}
		}
	}

	// *
	public void removeDups2() {
		Node temp = head;
		Node sortedHead = head, sortedTail = head;
		temp = head.next;
		sortedHead.next = null;
		while (temp != null) {
			if (sortedTail.value == temp.value)
				temp = temp.next;
			else {
				sortedTail.next = temp;
				sortedTail = temp;
				temp = temp.next;
				sortedTail.next = null;
			}
		}
		head = sortedHead;
		tail = sortedTail;
	}

	public void printList() {
		StringBuilder sb = new StringBuilder();
		for (Node node = head; node != null; node = node.next) {
			if (node != head)
				sb.append("-->");
			sb.append(node.value);
		}
		System.out.println(sb.toString());
	}

	public void printStack() {
		System.out.println("Elements in the stack are:");
		for (Node node = head; node != null; node = node.next) {
			System.out.println(node.value);
		}
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		// for (int i = 10; i > 0; i--) {
		// l.insertFirst(i);
		// }
		l.insertLast(2);
		l.insertLast(1);
		l.insertLast(1);
		l.insertLast(3);
		// l.insertLast(11);
		l.printList();
		// System.out.println(l.isPalindrome());
		// System.out.println(l.popFirst());
		// l.printList();
		// System.out.println(l.popLast());
		// l.printList();
		// l.insertAtk(-3, 15);
		// l.printList();
		// System.out.println(l.popAtk(-2));
		// l.printList();
		// l.reverseList();
		// l.sort();
		// l.reverseList_R();
		l.removeDups2();
		l.printList();

	}

}
