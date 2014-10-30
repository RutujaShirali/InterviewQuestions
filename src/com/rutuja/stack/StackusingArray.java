package com.rutuja.stack;

public class StackusingArray {
	int capacity = 5;
	int[] stack = new int[capacity];
	int top = -1;

	public void push(int element) {
		if (top < capacity - 1) {
			top += 1;
			stack[top] = element;
			System.out.println("Element " + element
					+ " has been pushed to stack");
		} else
			System.out.println("Stack overflow");
	}

	public int pop() {
		if (top >= 0) {
			System.out.println("pop operation is done");
			return stack[top--];
		} else {
			System.out.println("Stack underflow");
			return -1;
		}
	}

	public void print() {
		if (top > 0) {
			System.out.println("Elements in stack are: ");
			for (int i = 0; i <= top; i++) {
				System.out.println(stack[i]);
			}
		}
	}

	public static void main(String[] args) {
		StackusingArray a = new StackusingArray();
		for (int i = 1; i < 6; i++) {
			a.push(i);
		}
		System.out.println(a.pop());
		a.print();

	}

}
