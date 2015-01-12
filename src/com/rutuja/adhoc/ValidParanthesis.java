package com.rutuja.adhoc;

import java.util.Stack;

public class ValidParanthesis {

	public boolean check(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (curr == '(' || curr == '{' || curr == '[' || curr == '<')
				s.add(curr);
			else {
				char check = s.pop();
				if ((check == '{' && curr != '}')
						|| (check == '(' && curr != ')')
						|| (check == '<' && curr != '>'))
					return false;
			}

		}
		if (s.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidParanthesis vp = new ValidParanthesis();
		System.out.println(vp.check("({})"));

	}

}
