package com.rutuja.stack;

public class TwoStacks {

	int capacity = 10;
	int[] stacks = new int[capacity];
	int top1 = -1;
	int top2 = capacity;

	public void push1(int element) {
		if (top1 < top2 - 1) {
			top1++;
			stacks[top1] = element;
		} else {
			System.out.println("stacks are filled");
		}

	}

	public void push2(int element) {
		if (top1 < top2 - 1) {
			top2--;
			stacks[top2] = element;
		} else {
			System.out.println("Stacks are filled");
		}
	}

	public void print() {
		System.out.println("Elements in stack 1");
		for (int i = 0; i <= top1; i++) {
			System.out.println(stacks[i]);
		}
		System.out.println("Elements in Stack 2");
		for (int i = capacity - 1; i >= top2; i--) {
			System.out.println(stacks[i]);
		}
	}

	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks();
		for (int i = 0; i < 4; i++) {
			ts.push1(i);
		}
		for (int i = 10; i > 2; i--) {
			ts.push2(i);
		}

		ts.print();

	}

}
