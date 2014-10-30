package com.rutuja.stack;

import com.rutuja.lists.*;

public class StackusingLL {
	int top = -1;

	LinkedList ll = new LinkedList();

	public void push(int element) {
		ll.insertFirst(element);
		top++;
	}

	public int pop() {
		top--;
		System.out.println("popping, the new top is:" + top
				+ " and the element popped is: ");
		return ll.popFirst();
	}

	public void print() {
		ll.printStack();
	}

	public static void main(String[] args) {
		StackusingLL sl = new StackusingLL();
		for (int i = 1; i < 6; i++) {
			sl.push(i);
		}
		sl.print();
		System.out.println(sl.pop());
		System.out.println(sl.pop());
		sl.print();
	}

}
