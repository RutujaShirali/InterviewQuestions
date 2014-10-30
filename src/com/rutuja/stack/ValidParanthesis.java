package com.rutuja.stack;

import java.util.Stack;

public class ValidParanthesis {

	Stack<Character> stack = new Stack<Character>();

	public boolean isValid(String s) {
		boolean valid = false;
		for (int i = 0; i < s.length(); i++) {
			int val = isOpen(s.charAt(i));
			if (val == 1) {
				stack.push(s.charAt(i));
			} else if (val == 2) {
				char c = stack.pop();
				if ((c == '{' && s.charAt(i) == '}')
						|| (c == '(' && s.charAt(i) == ')')
						|| (c == '[' && s.charAt(i) == ']'))
					valid = true;
				else
					valid = false;

			}
		}
		if (valid == true && stack.isEmpty())
			return true;
		else
			return false;
	}

	public int isOpen(char c) {
		switch (c) {
		case '{':
			return 1;
		case '(':
			return 1;
		case '[':
			return 1;
		case ')':
			return 2;
		case '}':
			return 2;
		case ']':
			return 2;
		default:
			return -1;
		}

	}

	public static void main(String[] args) {
		ValidParanthesis vp = new ValidParanthesis();
		System.out.println(vp.isValid("{(}(}"));

	}

}
