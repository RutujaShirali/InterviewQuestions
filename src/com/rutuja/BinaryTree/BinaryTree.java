package com.rutuja.BinaryTree;

import java.util.LinkedList;

public class BinaryTree {
	Node root;

	class Node {
		int data;
		Node rightChild;
		Node leftChild;

		public Node(int data, Node rightChild, Node leftChild) {
			super();
			this.data = data;
			this.rightChild = rightChild;
			this.leftChild = leftChild;
		}

		public Node(int element) {
			this(element, null, null);
		}

		@Override
		public String toString() {
			return String.format("(%d)", data);
		}
	}

	private int height_R(Node r) {
		if (r == null)
			return 0;
		return 1 + Math.max(height_R(r.leftChild), height_R(r.rightChild));
	}

	public int height() {
		return height_R(root);
	}

	private int size_R(Node r) {

		if (r == null)
			return 0;
		else
			return 1 + size_R(r.leftChild) + size_R(r.rightChild);
	}

	public int size() {
		return size_R(root);
	}

	public void add(int element) {
		if (root == null)
			root = new Node(element);
		else {
			LinkedList<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node node = q.poll();
				if (node.leftChild == null || node.rightChild == null) {
					if (node.leftChild == null)
						node.leftChild = new Node(element);
					else
						node.rightChild = new Node(element);
					break;
				}
				if (node.leftChild != null)
					q.add(node.leftChild);
				if (node.rightChild != null)
					q.add(node.rightChild);

			}
		}
	}

	public void inOrder() {
		Node curr = root;
		LinkedList<Node> stack = new LinkedList<>();
		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.leftChild;
			} else {
				curr = stack.pop();
				System.out.print(curr.data + " ");
				curr = curr.rightChild;
			}
		}
		System.out.println();
	}

	public void preOrder() {
		if (root == null)
			return;
		LinkedList<Node> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			if (curr.rightChild != null) {
				stack.push(curr.rightChild);
			}
			if (curr.leftChild != null) {
				stack.push(curr.leftChild);
			}
			System.out.print(curr.data + " ");
		}
		System.out.println();
	}

	public void postOrder() {
		if (root == null)
			return;
		Node prev = null;
		LinkedList<Node> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node curr = stack.peek();
			// traversing down the tree
			if (prev == null || prev.leftChild == curr
					|| prev.rightChild == curr) {
				if (curr.leftChild != null) {
					stack.push(curr.leftChild);
				} else if (curr.rightChild != null) {
					stack.push(curr);
				} else {
					System.out.print(curr.data + " ");
					stack.pop();
				}

			}
			// traversing up the tree from left
			else if (curr.leftChild == prev) {
				if (curr.rightChild != null) {
					stack.push(curr.rightChild);
				} else {
					System.out.print(curr.data + " ");
					stack.pop();
				}

			}
			// traversing up the tree from right
			else if (curr.rightChild == prev) {
				System.out.print(curr.data + " ");
				stack.pop();
			}
			prev = curr;
		}
		System.out.println();
	}

	private Node[] findNode_R(Node r, int element, Node parent) {
		if (r == null)
			return null;
		if (r.data == element)
			return new Node[] { r, parent };
		Node[] temp = findNode_R(r.leftChild, element, r);
		if (temp == null)
			temp = findNode_R(r.rightChild, element, r);
		return temp;
	}

	public boolean contains(int element) {
		return findNode_R(root, element, null) != null;
	}

	public void delete(int element) {
		Node[] del = findNode_R(root, element, null);
		if (del != null) {
			Node node = del[0], parent = del[1];
			// Delete leaf node
			if (node.leftChild == null && node.rightChild == null) {
				if (parent == null)
					root = null;
				else if (parent.leftChild == node)
					parent.leftChild = null;
				else
					parent.rightChild = null;
			}
			// Delete node with one child
			else if (node.leftChild == null ^ node.rightChild == null) {
				Node child = node.leftChild == null ? node.rightChild
						: node.leftChild;
				if (parent == null)
					root = child;
				else if (parent.leftChild == node)
					parent.leftChild = child;
				else
					parent.rightChild = child;
			}
			// Delete node with 2 children
			else {
				Node succ = node.rightChild;
				while (succ.leftChild != null) {
					succ = succ.leftChild;
				}
				delete(succ.data);
				node.data = succ.data;
			}

		}
	}

	public int countLeaf() {
		return countLeaf(root);
	}

	private int countLeaf(Node r) {
		if (r == null)
			return 0;
		if (r.leftChild == null && r.rightChild == null)
			return 1;
		return countLeaf(r.leftChild) + countLeaf(r.rightChild);
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < 10; i++)
			tree.add(i);

		tree.printLevelOrder();
		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
		System.out.println(tree.countLeaf());

	}

	public void printLevelOrder() {
		LinkedList<Node> currentLevel = new LinkedList<>();
		LinkedList<Node> nextLevel = new LinkedList<>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			System.out.println(currentLevel);
			nextLevel.clear();
			while (!currentLevel.isEmpty()) {
				Node node = currentLevel.poll();
				if (node.leftChild != null)
					nextLevel.add(node.leftChild);
				if (node.rightChild != null)
					nextLevel.add(node.rightChild);
			}
			LinkedList<Node> temp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = temp;
		}

	}

	@Override
	public String toString() {
		return root != null ? root.toString() : "()";
	}

}
