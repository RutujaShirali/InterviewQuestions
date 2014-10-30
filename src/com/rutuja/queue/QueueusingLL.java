package com.rutuja.queue;

import com.rutuja.lists.*;

public class QueueusingLL {
	int front = 0, rear = 0;
	LinkedList ll = new LinkedList();

	public void enqueue(int element) {
		ll.insertLast(element);
		rear++;
	}

	public int dequeue() {
		front++;
		return ll.popFirst();
	}

	public void print() {
		ll.printStack();
	}

	public static void main(String[] args) {
		QueueusingLL ql = new QueueusingLL();
		ql.enqueue(10);
		ql.enqueue(20);
		ql.enqueue(30);
		ql.enqueue(40);
		System.out.println(ql.dequeue());
		ql.print();
	}

}
