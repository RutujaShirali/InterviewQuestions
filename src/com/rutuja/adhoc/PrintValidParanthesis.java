package com.rutuja.adhoc;

public class PrintValidParanthesis {

	private void print_R(int length, String s) {
		if (length % 2 != 0)
			s = "No valid paranthesis";
		if (length == 0)
			System.out.println(s);
		else {
			print_R(length - 2, "(" + s + ")");
			print_R(length - 2, "()" + s);
			print_R(length - 2, s + "()");
		}
	}

	public void print(int length) {
		print_R(length, "");
	}

	public static void main(String[] args) {
		PrintValidParanthesis pvp = new PrintValidParanthesis();
		pvp.print(4);

	}

}
