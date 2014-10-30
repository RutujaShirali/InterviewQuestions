package com.rutuja.stack;

public class InfixtoPostfix {
	int capacity = 10;
	char[] stack = new char[capacity];
	int top = -1;

	public String convert(String exp) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < exp.length(); i++) {
			if (isOperand(exp.charAt(i))) {
				sb.append(exp.charAt(i));
			} else {
				int val = precedence(exp.charAt(i));
				if (precedence(peek()) < val || top < 0) {
					push(exp.charAt(i));
				} else {
					while (top >= 0 && precedence(peek()) > val) {
						sb.append(pop());
					}
				}

			}
		}
		while (top >= 0) {
			sb.append(pop());
		}

		return sb.toString();
	}

	public char peek() {
		if (top >= 0)
			return (stack[top]);
		else
			return 'e';
	}

	public void push(char op) {
		if (top < capacity - 1) {
			top += 1;
			stack[top] = op;
		} else
			System.out.println("Stack overflow");
	}

	public char pop() {
		if (top >= 0) {
			return stack[top--];
		} else {
			System.out.println("Stack underflow");
			return 'e';
		}
	}

	public boolean isOperand(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	public int precedence(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		InfixtoPostfix ip = new InfixtoPostfix();
		System.out.println(ip.convert("a+b*c+d"));

	}

}
